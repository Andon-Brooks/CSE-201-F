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
    
    // The clock object for the game
    public static Clock clock = new Clock();
    
    // End of game summary counters
    public static boolean hasCaughtGary = false;
    public static int forfeits = 0;
    public static int trapsEncountered = 0;
    public static int trapsSolved = 0;
    public static int problemsEncountered = 0;
    public static int puzzlesEncountered = 0;
    public static int puzzlesSolved = 0;

    // Variables for if user doesn't solve enough traps, then they lose
    public static int unsolvedTraps = 0;
    public static final int MAX_UNSOLVED_TRAPS = 5;

    /**
     * Creates Objects needed to start the Game
     * Also prints the game start message/ description
     * 
     * @param sc System.in Scanner passed to tutorial for user I/O
     */
    public static void startGame(Scanner sc) {
        tutorial();
        roomList.clear();

        Room firstRoom = new Living();
        roomList.add(firstRoom);
        roomList.add(new Kitchen());
        roomList.add(new Bedroom());

        // New added rooms
        roomList.add(new Bathroom());
        roomList.add(new Office());
        roomList.add(new DiningRoom());
        
        gary = new Gary("mouse");
        currentRoom = firstRoom;
    }

    /**
     * A simple tutorial class to walk the user through 3 rooms
     * 
     * @param sc System.in Scanner for user I/O
     */
    public static void tutorial (Scanner sc) {
        // Start of game description
        System.out.println("\n--------------------------------------------------");
        System.out.println("----------- Welcome to 'Dom and Gary'! -----------");
        System.out.println("--------------------------------------------------\n");

        System.out.println("Your owner has just left for work and will be gone from 12:00 pm to 4:00 pm.");
        System.out.println("This gives you exactly 4 hours to catch Gary, the mischievous mouse, before the owner returns.");
        System.out.println("Use your time wisely and avoid distractions, as every minute counts!\n");

        System.out.println("In this game, you play as Dom, a housecat with one goal... to catch Gary, the mischievous mouse,");
        System.out.println("before your owner returns home! Explore the rooms, avoid Garys traps, solve puzzles & problems, and try to catch him in time!");
        System.out.println("\nEach move takes time, so choose your actions wisely. Good luck!");
        
        System.out.println("\nTutorial\n");
        System.out.println("--------------------------------------------------\n");

        ArrayList<Room> tList = new ArrayList<Room>();
        tList.add(new Living());
        tList.add(new Kitchen());
        tList.add(new Bedroom());
        printRooms(tList);

        String choice;
        boolean validChoice = false;

        // This could be designed better but it is fine for what it is 
        do {
            System.out.print("Where would you like to go? : ");
            choice = sc.nextLine().trim().toLowerCase();
            System.out.println("-----------------------------\n");

            for (int i = 0; i < tlist.size(); i++) {
                if (tList.get(i).getRoomName().toLowerCase().equals(choice)) {
                    validChoice = true;
                    if (choice.trim().toLowerCase().equals("living")) {
                        tList.get(i).situation(sc);
                        tList.remove(i);
                    }

                    if (choice.trim().toLowerCase().equals("kitchen")) {
                        tList.get(i).problem(sc);
                        tlist.remove(i);
                    }

                    if (choice.trim().toLowerCase().equals("kitchen")) {
                        tList.get(i).taunt(sc);
                        tlist.remove(i)
                    }
                }
            } 

            if (!validChoice) {
                System.out.println("\nInvalid choice, try again!");
                System.out.println("--------------------------\n");
            }
        } while(!tList.isEmpty());

        System.out.println("\nThe game begins now...\n");
        System.out.println("--------------------------------------------------\n");
    }

    /**
     * Resets and restarts the Game.
     */
    public static void restartGame() {
        System.out.println("\nRestarting game...\n");
        System.out.println("Avalible rooms to move to: ");
        printRooms(roomList);
        System.out.println();
    }

    /**
     * Gives the option to Continue, restart, quit, or get help (help not implemented)
     * 
     * @param sc System.in Scanner for user I/O
     */
    public static void mainMenu(Scanner sc) {
        String choice;
        boolean unValid;
        do {
            System.out.println("\nc -> Continue");
            System.out.println("r -> Restart");
            // System.out.println("h -> Help Menu");

            System.out.println("m -> Check Map");
            System.out.println("t -> Time Summary");    // I changed it from 'Health' Summary to 'Time' Summary. We don't really have a health application for Dom. At least not yet.

            System.out.println("q -> Quit");
            System.out.print("\nWhat would you like to do? : ");

            choice = sc.nextLine();
            System.out.println("------------------------------");

            unValid = false;

            switch (choice) {
            case "c":
                System.out.println("\nContuine the Game!");
                System.out.println("------------------\n");
                break;
            case "r":
                restartGame();
                break;
            // case "h":
            //     helpMenu(sc);
            //     break;
            case "m":
                checkMap();
                break;
            case "t":
                displayTimeSummary();
                break;
            case "q":
                System.out.println("\nYou have quit the game!");
                System.out.println("-----------------------\n");
                gameOver = true;
                displayStats();
                break;
            default:
                System.out.println("\nInvalid input, try again!");
                System.out.println("-------------------------");
                unValid = true;
            }
        } while (unValid);
    }

    // /**
    //  * Help menu with different help options
    //  * 
    //  * @param sc System.in Scanner for user I/O
    //  */
    // public static void helpMenu(Scanner sc) {
    //     String choice;
    //     boolean unValid;
    //     do {
    //         System.out.println("\n\n--- Help Menu ---\n");
    //         System.out.println("1 -> Help message 1");
    //         System.out.println("2 -> Help message 2");
    //         System.out.println("3 -> Help message 3");
    //         System.out.println("b -> Go Back");
    //         System.out.print("\nWhat would you like to do? : ");

    //         choice = sc.nextLine();
    //         System.out.println("------------------------------");
    //         unValid = false;

    //         switch (choice) {
    //         case "1":
    //             System.out.println("\nHelp message one still needs to be created\n");
    //             break;
    //         case "2":
    //             System.out.println("\nHelp message two still needs to be created\n");
    //             break;
    //         case "3":
    //             System.out.println("\nHelp message three still needs to be created\n");
    //             break;
    //         case "b":
    //             System.out.println("\nGoing Back...");
    //             System.out.println("-------------\n");
    //             break;
    //         default:
    //             System.out.println("\nInvalid input, try again!");
    //             System.out.println("-------------------------");
    //             unValid = true;
    //         }
    //     } while (unValid);
    // }

    /**
     * Helper method that prints a String containing all room names
     * 
     * @param list an ArrayList of rooms in which the rooms need to be printed
     */
    private static void printRooms(ArrayList<Room> list) {
        String result = "   ";
        for (Room r : list) {
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
        if (gameOver) return;  // Prevent further moves if the game is over

        System.out.println("\n\nEnter 'Back' to go back\n");
        System.out.println("Avalible rooms to move to: ");
        printRooms(roomList);
        System.out.println();

        String choice;

        do {
            System.out.print("Where would you like to go? : ");
            choice = sc.nextLine().trim().toLowerCase();
            System.out.println("-----------------------------\n");

            if (choice.trim().toLowerCase().equals("back")) {
                // System.out.println("MADE IT TO BACK"); // USed for testing
                return;
            }

            if (gameOver) return;  // Check if game ended due to time running out

            boolean validChoice = false;
            for (Room r : roomList) {
                if (r.getRoomName().toLowerCase().equals(choice)) {
                    validChoice = true;
                    clock.deductTime(5);
                    gary.move();
                    currentRoom = r;
                    // System.out.println("MADE IT TO SITUATION"); // Used for testing
                    currentRoom.setVisited(true);

                    if (currentRoom.equals(gary.getCurrentRoom())) {
                        catchGary();
                        return;
                    }

                    r.situation(sc);
                    // System.out.println("MADE IT PAST SITUATION"); // Used for Testing
                    return;
                }
            }
            if (!validChoice) {
                System.out.println("\nInvalid choice, try again!");
                System.out.println("--------------------------\n");
            }
        } while(!choice.equals("Back"));
    }

    /*
    * A simple method to check all visited and unvisted rooms
    */
    public static void checkMap() {

        clock.pause();

        System.out.println("\n\n------- Dom's Map -------\n");
        System.out.println("Visited Rooms:");
        for (Room r : roomList) {
            if (r.isVisited()) {
                System.out.println("- " + r.getRoomName());
            }
        }
        System.out.println("-------------------------\n");
        
        clock.resume();
    }

    /**
    * A Simple method to give a summary about time
    */
    public static void displayTimeSummary() {
        System.out.println("\n\n---------- Dom's Time Summary ----------\n");

        // Display time left before the owner returns
        System.out.println("Time Remaining: " + clock.getRemainingTime());
    
        // // List visited rooms
        // System.out.println("Visited Rooms:");
        // for (Room r : roomList) {
        //     if (r.isVisited()) {
        //         System.out.println("- " + r.getRoomName());      // There is an option for this in the 'Check Map' option though, so I don't think we need this
        //     }
        // }
    
        System.out.println("-------------------------------------\n");
    }

    /*
    * This method pritchs a message if Gary has been catch
    */
    public static void catchGary() {
        System.out.println("-----------------------------------------------------------------------------------------\n");
        System.out.println("\nCONGRATULATIONS! DOM HAS CAUGHT GARY!!!");
        hasCaughtGary = true;
        gameOver = true; // End the game as a win
        displayEndGameSummary();
    }

    /*
    * Method to display summary of information when the game ends
    */
    public static void displayEndGameSummary() {
        System.out.println("\n---------- End of Game Summary ----------\n");

        if (!hasCaughtGary && (clock.getHours() == 0 && clock.getMinutes() == 0)) {
            // Time ran out
            System.out.println("Time has run out! Your owner has returned home, and Gary is still loose!\n");
            System.out.println("GAME OVER - YOU LOST! :(\n");
        } else if (hasCaughtGary) {
            // Gary was caught with time limit
            System.out.println("CONGRATULATIONS, YOU HAVE WON!!! :)\n");
            System.out.println("You found Gary with... " + clock.getRemainingTime() + " to spare!");
        }

        displayStats();
        gameOver = true;
    }

    /*
    * Method that prints game statics
    * Called in the enf of game Summary 
    */
    public static void displayStats() {
        System.out.println("\n------------- Game Statistics -------------\n");
        System.out.println("Problems Encountered: " + problemsEncountered);
        System.out.println("Traps Encountered: " + trapsEncountered + " | Traps Solved: " + trapsSolved);
        System.out.println("Puzzles Encountered: " + puzzlesEncountered + " | Puzzles Solved: " + puzzlesSolved);
        System.out.println("Turns Forfeited: " + forfeits);
        System.out.println("------------------------------------------\n");
    }

    /*
    * Method to display you have lost from too many traps
    */
    public static void gameOverTraps() {
        System.out.println("\n--- GAME OVER! ---\n");
        System.out.println("Dom has been caught in too many traps and can't continue!\n");
        gameOver = true;
        displayEndGameSummary();
    }

    /**
     * Prints game over message stating how and why the game ended
     */
    public static void gameOverMessage() {
        System.out.println("Game Over!");
        System.out.println("----------\n");
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
