package teacher07b;

import battlecode.common.GameActionException;
import battlecode.common.RobotController;

public abstract class AbstractRobot {
    
    public abstract void takeAction(RobotController rc) throws GameActionException;
}
