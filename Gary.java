/**
 * Class: Gary
 * 
 * Author: Group F CSE 201
 * 
 * This class is for Gary objects to be created
 */

import java.util.Random;

/**
 * This class is for Gary objects to be created
 */
public class Gary {
    // The current room Gary is in
    private Room currentRoom;

    // The name of the Gary object (for cases where there are multiple)
    private String name;

    /**
     * Constructor for the Gary class
     * 
     * @param name the name of the Gary object
     */
    Gary(String name) {
        this.name = name;
        this.move();
    }

    /**
     * Handles the movement of Gary to a random room in the house
     * 
     * @return the room Gary moves to
     */
    public Room move() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(Game.roomList.size());
        this.currentRoom = Game.roomList.get(randomNumber);
        this.currentRoom.setWasGary(true);
        return currentRoom;
    }

    /**
     * Getter method for Gary's current room
     * 
     * @return Gary's current room
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    /**
     * Getter method for this Gary object's name
     * 
     * @return Gary's current room
     */
    public String getGaryName() {
        return name;
    }
}
