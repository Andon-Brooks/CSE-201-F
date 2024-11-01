import java.lang.Math;
import java.util.Scanner;

public abstract class Room {
    private String roomName;
    private boolean wasGary;

    Room(String roomName) {
        this.roomName = roomName;
        this.wasGary = false; // Initially, Gary has not been in this room
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean wasGary() {
        return wasGary;
    }

    public void setWasGary(boolean wasGary) {
        this.wasGary = wasGary;
    }

    public boolean equals(Room other) {
        if (this.roomName == other.roomName) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 
     */
    public void situation(Scanner sc) {
`       if (this.equals(Game.gary.currentRoom)) {
            this.catchGary(sc);
        } else if (this.wasGary != true) {
            System.out.println("Gary hasn't been in here so nothing is wrong");
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
                    System.out.Println("The situation choice method is messed up")
            }
        }
    }

    public abstract void trap(Scanner sc);
    
    public abstract void puzzle(Scanner sc);
    
    public abstract void problem(Scanner sc);
    
    public abstract void taunt(Scanner sc);
    
    public abstract void catchGary(Scanner sc);
}
