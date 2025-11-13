package teacher07b;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import battlecode.common.GameActionException;
import battlecode.common.GameActionExceptionType;
import battlecode.common.MapInfo;
import battlecode.common.MapLocation;
import battlecode.common.Message;
import battlecode.common.RobotController;
import battlecode.common.RobotInfo;
import battlecode.common.UnitType;

// An abstract class that moves a splasher around
// in different exploration patterns
public class Splasher extends AbstractRobot {
    
    MapLocation lastPainted;

    int currentDirection;

    // We don't want duplicate ruin locations
    Set<MapLocation> ruins;
    Set<MapLocation> walls;

    MapLocation homeTower; // the tower that spawned us

    MapLocation destination; // our mission assigned to us at birth

    public Splasher(RobotController rc) throws GameActionException {
        this.lastPainted = rc.getLocation();
        this.currentDirection = 0;
        this.ruins = new HashSet<>();
        this.homeTower = senseTower(rc);
        this.destination = null; // This determines whether we are in WAITING, or MOVING mode
    }

    public void getMission(RobotController rc) throws GameActionException {
        System.out.println("getMission home tower " + this.homeTower.toString());
        if (this.destination != null) {
            return;
        }

        // Paint while we are near our tower so radio communication can happen
        this.paint(rc);

        // Tell our tower we need a mission
        MapLocation here = rc.getLocation();
        RadioMessage msgToTower = new RadioMessage(Tower.FROM_SPLASHER, here.x, here.y, (byte)(rc.getID() & 0xFF));
        System.out.println("can send message " + rc.canSendMessage(this.homeTower, msgToTower.toInt()));

        if ((this.homeTower != null) && (rc.canSendMessage(this.homeTower))) {
            System.out.println("Sending message to home tower " + msgToTower.toString());
            rc.sendMessage(this.homeTower, msgToTower.toInt());
        }

        // Read messages up to 5 rounds back
        Message[] msgs = rc.readMessages(-1);
        for (Message msg : msgs) {
            int receivedMessage = msg.getBytes();
            RadioMessage msgFromTower = RadioMessage.fromInt(receivedMessage);

            // If the message is meant for us
            if (msgFromTower.sender == (rc.getID() & 0xFF)) {
                this.destination = new MapLocation(msgFromTower.x, msgFromTower.y);
                System.out.println("Destination " + this.destination.toString() + " for " + msgFromTower.sender);
                break;
            }
        }

    }

    // Sense nearby robots and if any of them are a type of tower
    // return the MapLocation of the first one (which should be the tower that spawned us)
    public static MapLocation senseTower(RobotController rc) throws GameActionException {
      
      // Sense nearby ally robots and print if any of them are towers
      RobotInfo[] allyRobots = rc.senseNearbyRobots(-1, rc.getTeam());

      for (RobotInfo ally : allyRobots) {
        try {
            if (Tower.isTower(ally.type)) {
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

    public void takeAction(RobotController rc) throws GameActionException {

        if (this.destination == null) {
            this.getMission(rc);
            return;
        }

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
        if (lastPainted.distanceSquaredTo(here) > 4) {

            this.paint(rc);

            MapInfo[] infos = rc.senseNearbyMapInfos();
            for (MapInfo info : infos) {
                if (info.hasRuin() && !ruins.contains(info.getMapLocation())) {
                    ruins.add(info.getMapLocation());
                }
            }
        }

    }

    public void paint(RobotController rc) throws GameActionException {
        MapLocation here = rc.getLocation();
        // Before we move, attack/paint the current location if we can (it's not already painted)
        if (rc.canPaint(here) && rc.canAttack(here)) {
            // Does this paint the primary color? How do we paint it our secondary color?
            rc.attack(here);
            lastPainted = here;
        } else {
            System.out.println("Cannot paint at " + here.toString());
        }
    }

}
