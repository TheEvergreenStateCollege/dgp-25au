import java.util.ArrayList;

public class Startup {
    //Startups instance variable an array list of cell locations and the startup's name
    private ArrayList<String> locationCells;
    private String name;

    public Startup(String name) {
        this.name = name;
    }

    //A setter method that updates the startup's location (random location provided by GameHelper placeStartup() method)
    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
        System.out.println(loc.toString());
    }

    //Your basic setter method
    public void setName(String n) {
        name = n;
    }

    public String checkYourself(String userInput) {
        String result = "miss";
        //The array list index of method in action if the user guess is one of the entries in the array list indexOf will return the array list location, if not indexOf will return -1
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            //Using array list's remove method to delete an entry
            locationCells.remove(index);

            //Using the isEmpty method to see if all the locations have been guessed
            if (locationCells.isEmpty()) {
                result = "kill";
                //Tell the user when a startup has been sunk
                System.out.println("Ouch! You sunk " + name + " :( ");
            } else {
                result = "hit";
                System.out.println("Wow, you hit " + name + "!");
            }
        } else {
            System.out.println("Oh no, you missed!");
        }
        //return hit or miss or kill
        return result;
    }
}