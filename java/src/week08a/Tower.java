package week08a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import battlecode.common.Message;
import battlecode.common.RobotController;
import battlecode.common.RobotInfo;
import battlecode.common.UnitType;

public class Tower extends AbstractRobot {

    // Message type bytes, upper byte of a message (<< 24)
    public final static byte FROM_TOWER = 0x1;
    public final static byte FROM_SPLASHER = 0x2;

    static UnitType[] PAINT_TOWER_TYPES = new UnitType[] {
      UnitType.LEVEL_ONE_PAINT_TOWER,
      UnitType.LEVEL_TWO_PAINT_TOWER,
      UnitType.LEVEL_THREE_PAINT_TOWER,
    };

    static UnitType[] MONEY_TOWER_TYPES = new UnitType[] {
      UnitType.LEVEL_ONE_MONEY_TOWER,
      UnitType.LEVEL_TWO_MONEY_TOWER,
      UnitType.LEVEL_THREE_MONEY_TOWER,
    };
    static List<UnitType> PAINT_TOWER_TYPES_LIST = Arrays.asList(PAINT_TOWER_TYPES);
    static List<UnitType> MONEY_TOWER_TYPES_LIST = Arrays.asList(MONEY_TOWER_TYPES);
    
// The final combined list
    private static final List<UnitType> TOWER_TYPES_LIST;

    static {
        // 1. Create a mutable list (e.g., ArrayList)
        List<UnitType> combinedList = new ArrayList<>();

        // 2. Add all elements from the first array/list
        combinedList.addAll(Arrays.asList(PAINT_TOWER_TYPES));

        // 3. Add all elements from the second array/list
        combinedList.addAll(Arrays.asList(MONEY_TOWER_TYPES));

        // 4. Assign the final, combined list
        // Optional: Wrap it in List.of() (Java 9+) or Collections.unmodifiableList()
        // to make it immutable, which is a good practice for public static final fields.
        //TOWER_TYPES_LIST = List.of(combinedList.toArray(new UnitType[0])); // Java 9+ for immutable list
        TOWER_TYPES_LIST = Collections.unmodifiableList(combinedList);
    }

    public static boolean isPaintTower(UnitType type) {
        return (PAINT_TOWER_TYPES_LIST.indexOf(type) != -1);
    }

    public static boolean isMoneyTower(UnitType type) {
        return (MONEY_TOWER_TYPES_LIST.indexOf(type) != -1);
    }

    public static boolean isTower(UnitType type) {
        return (TOWER_TYPES_LIST.indexOf(type) != -1);
    }

    int currentX;
    int currentY;
    int mapWidth;
    int mapHeight;
    UnitType type;
    MapLocation here;
    final int SPAWN_INTERVAL = 2;

    public Tower(RobotController rc) {
        this.mapWidth = rc.getMapWidth();
        this.mapHeight = rc.getMapHeight();
        this.currentX = 0;
        this.currentY = 0;
        this.type = rc.getType();
        this.here = rc.getLocation();
    }

    public void takeAction(RobotController rc) throws GameActionException {

        // Create exactly one robot on startup, at robot controller's location 
        // in a random direction
        Direction dir = RobotPlayer.getRandomDirection();
        MapLocation nextLoc = rc.getLocation().add(dir);

        if (RobotPlayer.turnCount % SPAWN_INTERVAL == 0) {
            if (Tower.isPaintTower(type)) {
                // Only a paint tower, and with enough resources, will be able to run this
                if (rc.canBuildRobot(UnitType.MOPPER, nextLoc)) {
                    rc.buildRobot(UnitType.MOPPER, nextLoc);
                }
            } else if (Tower.isMoneyTower(type)) {
                // we are a money tower
                if (rc.canBuildRobot(UnitType.SPLASHER, nextLoc)) {
                    rc.buildRobot(UnitType.SPLASHER, nextLoc);
                }
            }
        }

        // Receive messages from nearby locations of robots just starting up
        // who need a mission
        Message[] msgs = rc.readMessages(-1);

        // All of these messages are from robots who are
        // newly created and need a destination

        for (Message msg : msgs) {
            // Parse a message to see if it's from a splasher
            // needing a mission

            RadioMessage msgFromSplasher = RadioMessage.fromInt(msg.getBytes());
            System.out.println("Received from splasher " + msg.getBytes());
            MapLocation senderLoc = new MapLocation(msgFromSplasher.x, msgFromSplasher.y);
            System.out.println("Parsed from splasher " + msgFromSplasher.toString());
            if (msgFromSplasher.type == Tower.FROM_TOWER) {
                System.out.println("Tower Sender" + msgFromSplasher.sender);
            } else {
                // Message is from a splasher
                RadioMessage msgToSplasher = new RadioMessage(Tower.FROM_TOWER, this.currentX, this.currentY, msg.getSenderID());
                System.out.println("Splasher Sender" + msgFromSplasher.sender + " at location " + senderLoc.toString() + " with msg " + msgToSplasher.toString());
                rc.sendMessage(senderLoc, msgToSplasher.toInt());
            }
            
            // We reserve lower 8 bits of our message for
            // least significant 8 bits

/*
            rc.sendMessage(here, messageInt);
            this.currentX += 1;
            this.currentY += 1;

 * 
 */
        }
    }

}
