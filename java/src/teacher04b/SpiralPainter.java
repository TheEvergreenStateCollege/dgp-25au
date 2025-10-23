package teacher04b;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.MapInfo;
import battlecode.common.MapLocation;
import battlecode.common.PaintType;
import battlecode.common.RobotController;

public class SpiralPainter extends SplasherPainter {

    public SpiralPainter(RobotController rc) {
        super(rc);
    }

    // Return the direction in advance of this one by the given amount,
    // with wraparound
    public Direction cyclicDirection(int advance) {
        return RobotPlayer.directions[(currentDirection + advance) % RobotPlayer.directions.length];
    }

    // East is inward of North, South inward of East, West inward of South, North inward of west
    // they are exactly 2 apart in the Directions wheel
    public Direction inward() {
        return cyclicDirection(2);
    }

    public Direction inForward() {
        return cyclicDirection(1);
    }

    public boolean shouldTurn(RobotController rc) throws GameActionException {
        MapLocation here = rc.getLocation();
        // Cell immediately inward in the spiral
        MapInfo inward = rc.senseMapInfo(here.add(inward()));
        MapInfo inForward = rc.senseMapInfo(here.add(inForward()));

        // Turn if our inward tile is marked, but our inward-forward tile is not marked
        return (inward.getMark() == PaintType.ALLY_PRIMARY) &&
          (inForward.getMark() != PaintType.ALLY_PRIMARY);
    }

    public void moveAndExplore(RobotController rc) throws GameActionException {

        Direction d = RobotPlayer.directions[currentDirection];

        if (rc.canMove(d) && !shouldTurn(rc)) {
            // Move and mark as we go along
            rc.mark(rc.getLocation(), false);
            rc.move(d);
        } else {
            // If we've reached here, we can't move or we should turn.
            // Assume we should turn for now
            currentDirection = (currentDirection + 2) % RobotPlayer.directions.length;
            rc.mark(rc.getLocation(), false);
            rc.move(d);
            System.out.println("Turning to " + RobotPlayer.directions[currentDirection].toString());
        }

        MapInfo[] infos = rc.senseNearbyMapInfos();
        for (MapInfo info : infos) {
            MapLocation infoHere = info.getMapLocation();
            if (info.hasRuin() && !ruins.contains(infoHere)) {
                ruins.add(infoHere);
                System.out.println(String.format("Found a ruin at %s", infoHere));
            }
        }
    }

}
