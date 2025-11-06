package week06a;

import battlecode.common.*;

public class Mopper extends AbstractMover {

    static final int RETRY_MAX = 5;
    
    int currentDirection;
    int senseInterval; // wait this number of turns before sensing and moving to unpaint
    MapLocation enemyPaintTarget; // null before we've found a target, 
    int moveCount; // number of times we are moving

    public Mopper(int senseInterval) {
        currentDirection = 0;
        this.senseInterval = senseInterval;
        this.enemyPaintTarget = null;
        this.moveCount = 0;
    }

    // We have two modes / states: searching and approaching
    // SEARCHING: we don't have a target and are searching for one
    // APPROACHING: we have a target and are approaching or unpainting it
    public void moveAndExplore(RobotController rc) throws GameActionException {

        Direction d = RobotPlayer.directions[currentDirection];

        while (!rc.canMove(d)) {
            currentDirection = (currentDirection + 1) % RobotPlayer.directions.length;
            d = RobotPlayer.directions[currentDirection];
        }

        // If we are in approaching mode
        if (enemyPaintTarget != null) {
            // If we can move to the target, do so
            // otherwise, randomly choose another direction
            MapLocation here = rc.getLocation();

            while (rc.canMove(d)) {
                here = rc.getLocation();
                d = here.directionTo(enemyPaintTarget);
                rc.move(d);
                this.moveCount += 1;

                // If we're at the target, unpaint it and unset our target
                if (here.isWithinDistanceSquared()) {
                    rc.attack(enemyPaintTarget);
                    enemyPaintTarget = null;
                }
            }

        } else {
            // we don't have a target yet, move
            while (rc.canMove(d)) {
                rc.move(d);
                this.moveCount += 1;
                senseAndTarget(rc);
            }

        }



    }

    public void senseAndTarget(RobotController rc) throws GameActionException {

        // If it's time for us to refresh our view of the environment,
        // and we don't have a goal already
        if ((this.moveCount % this.senseInterval) == 0 && (enemyPaintTarget == null)) {
            MapInfo[] tiles = rc.senseNearbyMapInfos(4);
            for (MapInfo tile : tiles) {
                if ((tile.getPaint() == PaintType.ENEMY_PRIMARY) ||
                    (tile.getPaint() == PaintType.ENEMY_SECONDARY)) {
                        enemyPaintTarget = tile.getMapLocation();
                        System.out.println("Target Acquired!" + enemyPaintTarget.toString());
                        break;
                }
            }
            this.moveCount = 0;
        }

    }
}
