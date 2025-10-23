package teacher04b;

import java.util.HashSet;
import java.util.Set;

import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import battlecode.common.RobotController;

// An abstract class that moves a splasher around
// in different exploration patterns
public abstract class SplasherPainter {
    
    MapLocation lastPainted;

    int currentDirection;

    // We don't want duplicate ruin locations
    Set<MapLocation> ruins;

    public SplasherPainter(RobotController rc) {
        this.lastPainted = rc.getLocation();
        this.currentDirection = 0;
        this.ruins = new HashSet<>();
    }

    public abstract void moveAndExplore(RobotController rc) throws GameActionException;

}
