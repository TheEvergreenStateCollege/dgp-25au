package teacher05b;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;

public abstract class AbstractMover {
    
    public abstract void moveAndExplore(RobotController rc) throws GameActionException;
}
