import java.util.Random;
import java.util.Scanner;
/**
 * Abstract room class from which all different room classes extend
 */
public abstract class Room {
    // The name of the room
    private final String roomName;

    private boolean visited = false;    // Visited room    

    // Marked as true when Gary enters a room
    private boolean wasGary;

    /**
     * Constructor for the Room class
     * 
     * @param roomName the name of the room
     */
    Room(String roomName) {
        this.roomName = roomName;
        this.wasGary = false; // Initially, Gary has not been in this room
    }
    
    /**
     * Getter method for room name
     * 
     * @return String of the rooms name
     */
    public String getRoomName() {
        return roomName;
    }


    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    
    /**
     * Getter method for wasGary
     * 
     * @return true if Gary has been in the room, false otherwise
     */
    public boolean getWasGary() {
        return wasGary;
    }

    /**
     * Setter class for wasGary
     * 
     * @param wasGary true if Gary has been in the room, false otherwise
     */
    public void setWasGary(boolean wasGary) {
        this.wasGary = wasGary;
    }

    /**
     * Overridden equals method to compare Room classes
     * 
     * @param other the room to be compared to
     * 
     * @return True if the have the same name, false otherwise
     */
    public boolean equals(Room other) {
        if (this.roomName == other.roomName) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Randomly picks a situation from the possible room situations, or catchGary
     * if Gary is currently in the room 
     * 
     * @param sc System.in Scanner for user I/O
     */
    public void situation(Scanner sc) {
        if (this.equals(Game.gary.getCurrentRoom())){
            this.catchGary(sc);
        } else if (this.wasGary != true) {
            System.out.println("\nGary hasn't been in here so nothing is wrong!\n-----\n");
            return;
        } else {
            Random rand = new Random();
            int randomNumber = rand.nextInt(4) + 1;
            switch (randomNumber) {
                case 1:
                    this.trap(sc);
                    break;
                case 2:
                    this.puzzle(sc);
                    break;
                case 3:
                    this.problem(sc);
                    break;
                case 4:
                    this.taunt(sc);
                    break;
                default:
                    System.out.println("\nThe situation choice method is messed up\n");
            }
        }
    }

    /**
     * Gives options to get out of a trap set by Gary
     * 
     * @param sc System.in Scanner for user I/O
     */
    public abstract void trap(Scanner sc);
    
    /**
     * GIves options to solve a puzzle set by Gary
     * 
     * @param sc System.in Scanner for user I/O
     */
    public abstract void puzzle(Scanner sc);
    
    /**
     * Gives options to handle a trap set by Gary
     * 
     * @param sc System.in Scanner for user I/O
     */
    public abstract void problem(Scanner sc);
    
    /**
     * Prints a taunt message from Gary
     * 
     * @param sc System.in Scanner for user I/O
     */
    public abstract void taunt(Scanner sc);
    
    /**
     * If Gary is currently in the room, gives options to catch Gary and win the game
     * 
     * @param sc System.in Scanner for user I/O
     */
    public abstract void catchGary(Scanner sc);
}
