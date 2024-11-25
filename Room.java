/**
 * Class: Room
 * 
 * Author: Group F CSE 201
 * 
 * Abstract room class from which all different room classes extend
 */

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * Abstract room class from which all different room classes extend
 */
public abstract class Room {
    // The name of the room
    private final String roomName;

    // Marked as true when Gary enters a room
    private boolean wasGary;

    /**
     * Constructor for the Room class
     * 
     * @param roomName the name of the room
     */
    Room(String roomName) {
        this.roomName = roomName;
        this.wasGary = false;
    }
    
    /**
     * Overwritten equals class to compare different rooms
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } 
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Room r = (Room) other;
        return Objects.equals(this.roomName, r.roomName);
    }
    
    /**
     * Overwritten hashCode method so that we can have a hashMap of rooms
     */
    @Override
    public int hashCode() {
        return Objects.hash(roomName);
    }

    /**
     * Getter method for room name
     * 
     * @return String of the rooms name
     */
    public String getRoomName() {
        return roomName;
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
     * Setter method for wasGary
     * 
     * @param wasGary true if Gary has been in the room, false otherwise
     */
    public void setWasGary(boolean wasGary) {
        this.wasGary = wasGary;
    }

    /**
     * Randomly picks a situation from the possible room situations, or
     * catchGary if Gary is currently in the room, or states that Gary
     * hasn't been in the room.
     * 
     * @param sc System.in Scanner for user I/O
     */
    public void situation(Scanner sc) {
        if (this.equals(Game.gary.getCurrentRoom())) {
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
                System.err.println("\nThe situation choice method is messed up\n");
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
     * Gives options to solve a puzzle set by Gary
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
     * If Gary is currently in the room, gives options to catch Gary and win the
     * game
     * 
     * @param sc System.in Scanner for user I/O
     */
    public abstract void catchGary(Scanner sc);
}
