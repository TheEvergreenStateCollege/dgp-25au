package week08a;

import battlecode.common.GameActionException;
import battlecode.common.MapInfo;
import battlecode.common.MapLocation;
import battlecode.common.RobotController;

public class RandomPainter extends SplasherPainter {
    
    public RandomPainter(RobotController rc) throws GameActionException {
        super(rc);
    }

    public void moveAndExplore(RobotController rc) throws GameActionException {
        // Cycle through directions until we find one where we are not blocked
        while (!rc.canMove(RobotPlayer.directions[currentDirection])) {
            // switch to a new random direction
            currentDirection = RobotPlayer.rng.nextInt(RobotPlayer.directions.length);
        }

        // Get our current location
        MapLocation here = rc.getLocation();

        // move in that direction
        rc.move(RobotPlayer.directions[currentDirection]);

        // Only paint if we are more than 3 tiles away from the last time we painted
        if (lastPainted.distanceSquaredTo(here) > 9) {
            // Before we move, attack/paint the current location if we can (it's not already painted)
            if (rc.canPaint(here) && rc.canAttack(here)) {
                // Does this paint the primary color? How do we paint it our secondary color?
                rc.attack(here);
                lastPainted = here;
            } else {
                System.out.println("Cannot paint at " + here.toString());
            }

            MapInfo[] infos = rc.senseNearbyMapInfos();
            for (MapInfo info : infos) {
                if (info.hasRuin() && !ruins.contains(info.getMapLocation())) {
                    ruins.add(info.getMapLocation());
                }
            }
        }

    }
}
