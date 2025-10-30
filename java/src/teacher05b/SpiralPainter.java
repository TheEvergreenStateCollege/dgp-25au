package teacher05b;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.MapInfo;
import battlecode.common.MapLocation;
import battlecode.common.PaintType;
import battlecode.common.RobotController;

public class SpiralPainter extends SplasherPainter {

    // Whether we have gotten as far as we can and we should switch 
    // to going home mode
    boolean goHome;

    public SpiralPainter(RobotController rc) throws GameActionException {
        super(rc);
        goHome = false;
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

        Direction inwardDir = inward();
        Direction inForwardDir = inForward();

        MapLocation inwardLoc = here.add(inwardDir);
        MapLocation inForwardLoc = here.add(inForwardDir);
        // Cell immediately inward in the spiral
        MapInfo inward = rc.senseMapInfo(inwardLoc);
        MapInfo inForward = rc.senseMapInfo(inForwardLoc);

        //return (inward.getMark() == PaintType.ALLY_PRIMARY) &&
        // We should always turn if our inforward is unmarked?
        System.out.println(inForwardDir.toString() + " " + inForward.toString() + " " + inForwardLoc.toString() + " " + inForward.getMark().toString());
        // Turn if our inward-forward tile is not marked *and* we can move to the turned
        // direction in the next turn. If we can't move there and it's unmarked, it's
        // likely occupied by a tower, robot, wall, ruin.
        return (inForward.getMark() != PaintType.ALLY_PRIMARY) && rc.canMove(inForwardDir);
    }

    public void moveAndExplore(RobotController rc) throws GameActionException {

        MapLocation here = rc.getLocation();

        // If we're in go home mode
        if (goHome) {
            rc.move(here.directionTo(homeTower));
            return;
        }

        // Otherwise, explore the spiral
        Direction d = RobotPlayer.directions[currentDirection];
        if (rc.canMove(d)) {
            // Move and mark as we go along
            
            rc.mark(here, false);
            boolean turned = shouldTurn(rc); // measure this before we move
            rc.move(d);
            if (turned) {
                // If we've reached here, we can't move or we should turn.
                // Assume we should turn for now
                currentDirection = (currentDirection + 2) % RobotPlayer.directions.length;
                d = RobotPlayer.directions[currentDirection];
                // turn next time
                System.out.println(String.format("%s Turning to %s", here.toString(), d.toString()));
            }
        } else {
            // if we get stuck, switch to goHome mode for next time
            goHome = true;
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
