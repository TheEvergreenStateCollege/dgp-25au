package teacher05b;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import battlecode.common.GameActionException;
import battlecode.common.GameActionExceptionType;
import battlecode.common.MapLocation;
import battlecode.common.RobotController;
import battlecode.common.RobotInfo;
import battlecode.common.UnitType;

// An abstract class that moves a splasher around
// in different exploration patterns
public abstract class SplasherPainter extends AbstractMover {
    
    MapLocation lastPainted;

    int currentDirection;

    // We don't want duplicate ruin locations
    Set<MapLocation> ruins;
    Set<MapLocation> walls;

    MapLocation homeTower; // the tower that spawned us

    public SplasherPainter(RobotController rc) throws GameActionException {
        this.lastPainted = rc.getLocation();
        this.currentDirection = 0;
        this.ruins = new HashSet<>();
        this.homeTower = senseTower(rc);
    }

    static UnitType[] PAINT_TOWER_TYPES = new UnitType[] {
      UnitType.LEVEL_ONE_PAINT_TOWER,
      UnitType.LEVEL_TWO_PAINT_TOWER,
      UnitType.LEVEL_THREE_PAINT_TOWER
    };
    static List<UnitType> PAINT_TOWER_TYPES_LIST = Arrays.asList(PAINT_TOWER_TYPES);

    // Sense nearby robots and if any of them are a type of tower
    // return the MapLocation of the first one (which should be the tower that spawned us)
    public static MapLocation senseTower(RobotController rc) throws GameActionException {
      
      // Sense nearby ally robots and print if any of them are towers
      RobotInfo[] allyRobots = rc.senseNearbyRobots(-1, rc.getTeam());

      MapLocation here = rc.getLocation();
      for (RobotInfo ally : allyRobots) {
        MapLocation allyLoc = ally.getLocation();
        try {
            if ((PAINT_TOWER_TYPES_LIST.indexOf(ally.type) != -1)) {
                String message = String.format("Paint tower found at %d,%d", ally.location.x, ally.location.y);
                System.out.println(message);
                // this ally is a paint tower
                return ally.getLocation();
            }
        } catch (Exception e) {
            System.err.println(e.toString());
            e.printStackTrace();
        }
      }

      throw new GameActionException(GameActionExceptionType.NO_ROBOT_THERE, "No home tower found.");
    }

    public abstract void moveAndExplore(RobotController rc) throws GameActionException;

}
