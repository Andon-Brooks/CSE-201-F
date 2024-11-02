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
        return getCurrentRoom();
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
     * A setter method for Gary's current room
     * 
     * @param currentRoom the room Gary is to be moved to
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
