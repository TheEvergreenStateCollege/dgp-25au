package teacher05b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

import battlecode.common.RobotController;
import battlecode.common.RobotInfo;
import battlecode.common.UnitType;

public class Tower {

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

}
