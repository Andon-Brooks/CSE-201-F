import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class contains the main functions of the game that are called
 * from this, and other classes
 */
public class Game {
    // An arrayList to store all of the rooms in the house
    public static ArrayList<Room> roomList = new ArrayList<Room>();

    // The mouse for the game (can be turned into a list of mice in the future)
    public static Gary gary;
    
    // Controls if the game has ended or not
    public static boolean gameOver = false;
    
    // Holds the current room that the user is in
    private static Room currentRoom;

    /**
     * Creates Objects needed to start the Game
     * Also prints the game start message/ description
     */
    public static void startGame() {
        Room firstRoom = new Living();
        roomList.add(firstRoom);
        // roomList.add(new LivingRoom());
        roomList.add(new Kitchen());
        roomList.add(new Bedroom());
        // roomList.add(new Bathroom());
        // roomList.add(new DinningRoom());
        // roomList.add(new Office());
        // roomList.add(new LaundryRoom());

        gary = new Gary("mouse");
        currentRoom = firstRoom;
        System.out.println("Welcome to Dom and Gary!!"); // Can change this if needed
    }
    
    /**
     * Gives the option to Continue, restart, quit, or get help
     * 
     * @param sc System.in Scanner for user I/O
     */
    public static void mainMenu(Scanner sc) {
        String choice;
        boolean unValid;
        do {
            System.out.println("c -> Continue");
            System.out.println("r -> Restart");
            System.out.println("h -> Help Menu");
            System.out.println("q -> Quit");
            System.out.print("What would you like to do? : ");

            choice = sc.nextLine();
            unValid = false;
            switch (choice) {
            case "c":
                System.out.println("Contuine the Game!");
                break;
            case "r":
                System.out.println("Restart not available yet");
                break;
            case "h":
                helpMenu(sc);
                break;
            case "q":
                System.out.println("You have quit the game!");
                gameOver = true;
                break;
            default:
                System.out.println("Invalid input, try again ");
                unValid = true;
            }
        } while (unValid);
    }

    /**
     * Help menu with different help options
     * 
     * @param sc System.in Scanner for user I/O
     */
    public static void helpMenu(Scanner sc) {
        String choice;
        boolean unValid;
        do {
            System.out.println("0 -> Help message 0");
            System.out.println("1 -> Help message 1");
            System.out.println("2 -> Help message 2");
            System.out.println("b -> Go Back");
            System.out.print("What would you like to do? : ");

            choice = sc.nextLine();
            unValid = false;
            switch (choice) {
            case "0":
                System.out.println("Help message zero");
                break;
            case "1":
                System.out.println("Help message one");
                break;
            case "2":
                System.out.println("Help message two");
                break;
            case "b":
                System.out.println("Go BAck");
                break;
            default:
                System.out.println("Invalid input, try again ");
                unValid = true;
            }
        } while (unValid);
    }

    /**
     * Helper method that prints a String containing all room names
     */
    private static void printRooms() {
        String result = "   ";
        for (Room r : roomList) {
            result += r.getRoomName() + "   ";
        }
        System.out.println(result);
    }

    /**
     * Moves player to a chosen room and does that rooms random situation
     * Gary's moves are also triggered in this method
     * 
     * @param sc System.in Scanner for user I/O
     */
    public static void move(Scanner sc) {
            System.out.println("\nEnter 'Back' to go back");
            System.out.println("Avalible rooms to move to: ");
            printRooms();
            String choice;
        do {
            System.out.print("Where would you like to go? : ");
            choice = sc.nextLine();
            if (choice.equals("Back")) {
                // System.out.println("MADE IT TO BACK"); // USed for testing
                return;
            }

            for (Room r : roomList) {
                if (r.getRoomName().equals(choice)) {
                    gary.move();
                    currentRoom = r;
                    // System.out.println("MADE IT TO SITUATION"); // Used for testing
                    r.situation(sc);
                    // System.out.println("MADE IT PAST SITUATION"); // Used for Testing
                    return;
                }
            }
            System.out.println("Invalid choice, try again! ");
        } while(!choice.equals("Back"));
    }

    /**
     * Prints a notification containing...
     */
    public void notification() {
        System.out.println("This is a notification full of information");
    }

    /**
     * Prints game over message stating how and why the game ended
     */
    public static void gameOverMessage() {
        System.out.println("Game Over :(");
    }
    
    /**
     * Getter method for currentRoom variable
     * 
     * @return the current room of the user
     */
    public static Room getCurrentRoom() {
        return currentRoom;
    }
    
    /**
     * Setter method for the currentRoom variable
     * 
     * @param currentRoom the room the current room is to be set to
     */
    public static void setCurrentRoom(Room currentRoom) {
        Game.currentRoom = currentRoom;
    }
}
