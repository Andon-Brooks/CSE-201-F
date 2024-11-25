/**
 * Class: Game
 * 
 * Author: Group F CSE 201
 * 
 * This class contains the main functions of the game that are called from this,
 * and other classes
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * This class contains the main functions of the game that are called from this,
 * and other classes
 */
public class Game {
    // An arrayList to store all of the rooms in the house
    protected static ArrayList<Room> roomList = new ArrayList<Room>();

    // The mouse for the game (can be turned into a list of mice in the future)
    public static Gary gary;

    // Controls if the game has ended or not
    public static boolean gameOver = false;

    // Holds the current room that the user is in
    private static Room currentRoom;

    // The clock object for the game
    public static Clock clock = new Clock(4, 0);

    // End of game summary counters
    public static boolean hasCaughtGary = false;
    public static int trapsEncountered = 0;
    public static int trapsSolved = 0;
    public static int puzzlesEncountered = 0;
    public static int puzzlesSolved = 0;
    public static int problemsEncountered = 0;
    public static int problemsSolved = 0;
    public static int tauntsEncountered = 0;
    public static int GaryEncounters = 0;
    public static int GarysCaught = 0;
    public static int forfeits = 0;
    public static HashMap<String, Integer> visits = new HashMap<>();

    // Variables for if user doesn't solve enough traps, then they lose
    public static final int MAX_UNSOLVED = 5;
    
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
    
    /**
     * Creates Objects needed to start the Game Also prints the game start
     * message/ description
     * 
     * @param sc System.in Scanner passed to tutorial for user I/O
     */
    public static void startGame(Scanner sc) {
        // test(sc); // Just used to test rooms in development
        tutorial(sc);
        roomList.clear();
        clock = new Clock(4, 0);
        gameOver = false;
        
        trapsEncountered = 0;
        trapsSolved = 0;
        puzzlesEncountered = 0;
        puzzlesSolved = 0;
        problemsEncountered = 0;
        problemsSolved = 0;
        tauntsEncountered = 0;
        GaryEncounters = 0;
        GarysCaught = 0;
        forfeits = 0;
        visits.clear();

        Room firstRoom = new Living();
        roomList.add(firstRoom);
        roomList.add(new Kitchen());
        roomList.add(new Bedroom());
        roomList.add(new Bathroom());
        roomList.add(new Office());
        roomList.add(new DiningRoom());
        
        gary = new Gary("mouse");
        currentRoom = firstRoom;
    }

    /**
     * Extra method that can be used by dev's to test game rooms/ features
     * 
     * @param sc System.in Scanner for user I/O
     */
    @SuppressWarnings("unused")
    private static void test(Scanner sc) {
        Room r = new Bathroom();
        r.catchGary(sc);
    }

    /**
     * A simple tutorial class to walk the user through 3 rooms
     * 
     * @param sc System.in Scanner for user I/O
     */
    public static void tutorial(Scanner sc) {
        // Start of game description
        System.out.println("-------------------------------------------");
        System.out.println("-------- Welcome to 'Dom and Gary' --------");
        System.out.println("-------------------------------------------\n");

        System.out.println("Your owner has just left for work and will be gone from 12:00 pm to 4:00 pm.");
        System.out.println("This gives you exactly 4 hours to catch Gary, the mischievous mouse, before the owner returns.");
        System.out.println("Use your time wisely and avoid distractions, as every minute counts!\n");

        System.out.println("In this game, you play as Dom, a housecat with one goal... to catch Gary, the mischievous mouse,");
        System.out.println("before your owner returns home! Explore the rooms, avoid Garys traps, solve puzzles & problems, and try to catch him in time!");
        System.out.println("\nEach move takes time, so choose your actions wisely. Good luck!");

        System.out.println("\nTutorial");
        System.out.println("-------------------------------------------\n");

        // The rooms are specific to the function, if they are changed the if
        // statements below also need to be changed
        ArrayList<Room> tList = new ArrayList<Room>();
        tList.add(new Living());
        tList.add(new Kitchen());
        tList.add(new Bedroom());

        String choice;
        boolean validChoice = false;

        // This could be designed better but it is fine for what it is
        do {
            System.out.println("Enter 'Back' to go back\n");
            System.out.println("Avalible rooms to move to: ");
            printRooms(tList);
            System.out.print("Where would you like to go?: ");
            choice = sc.nextLine().trim().toLowerCase();
            System.out.println("-------------------------------------------");

            for (int i = 0; i < tList.size(); i++) {
                if (tList.get(i).getRoomName().toLowerCase().equals(choice)) {
                    validChoice = true;
                    if (choice.trim().toLowerCase().equals("living")) {
                        tList.get(i).trap(sc);
                        tList.remove(i);
                    }

                    if (choice.trim().toLowerCase().equals("bedroom")) {
                        tList.get(i).problem(sc);
                        tList.remove(i);
                    }

                    if (choice.trim().toLowerCase().equals("kitchen")) {
                        tList.get(i).taunt(sc);
                        tList.remove(i);
                    }
                }
            }

            if (!validChoice) {
                System.out.println("Invalid choice, try again!");
                System.out.println("-------------------------------------------\n");
            }
        } while (!tList.isEmpty());

        System.out.println("\nThe game begins now!");
        System.out.println("-------------------------------------------\n");
    }

    /**
     * Gives the option to Continue, restart, quit, or get help (help not
     * implemented)
     * 
     * @param sc System.in Scanner for user I/O
     */
    public static void mainMenu(Scanner sc) {
        String choice;
        boolean unValid;
        do {
            System.out.println("c -> Continue");
            System.out.println("r -> Restart");
            System.out.println("m -> Check Map");
            System.out.println("t -> Time Summary");
            System.out.println("q -> Quit");
            System.out.print("\nWhat would you like to do?: ");

            choice = sc.nextLine();
            unValid = false;

            switch (choice) {
            case "c":
                System.out.println("-------------------------------------------");
                System.out.println("Contuine the Game!");
                System.out.println("-------------------------------------------\n");
                break;
            case "r":
                System.out.println("\nRestarting game...\n");
                startGame(sc);
                break;
            case "m":
                printVisitMap();
                break;
            case "t":
                displayTimeSummary();
                break;
            case "q":
                System.out.println("-------------------------------------------");
                System.out.println("You have quit the game!");
                System.out.println("-------------------------------------------\n");
                gameOver = true;
                break;
            default:
                System.out.println("-------------------------------------------");
                System.out.println("Invalid input, try again!");
                System.out.println("-------------------------------------------");
                unValid = true;
            }
        } while (unValid);
    }

    /**
     * Moves player to a chosen room and does that room's random situation. Gary's
     * moves are also triggered in this method
     * 
     * @param sc System.in Scanner for user I/O
     */
    public static void move(Scanner sc) {
        String choice;

        do {
            System.out.println("Enter 'Back' to go back\n");
            System.out.println("Avalible rooms to move to: ");
            printRooms(roomList);
            System.out.print("Where would you like to go?: ");
            choice = sc.nextLine().trim().toLowerCase();
            System.out.println("-------------------------------------------\n");

            if (choice.trim().toLowerCase().equals("back")) {
                return;
            }

            boolean validChoice = false;
            for (Room r : roomList) {
                if (r.getRoomName().toLowerCase().equals(choice)) {
                    validChoice = true;
                    clock.deductTime(5);
                    gary.move();
                    currentRoom = r;
                    countVisits(currentRoom);
                    currentRoom.situation(sc);
                    checkTraps();
                    return;
                }
            }
            if (!validChoice) {
                System.out.println("Invalid choice, try again!");
                System.out.println("-------------------------------------------\n");
            }
        } while (!choice.equals("Back"));
    }
    
    /**
     * private helper method to check if too many traps have been failed
     * 
     * @return true if too many traps have been failed, false otherwise
     */
    private static boolean checkTraps() {
        if ((trapsEncountered - trapsSolved) >= MAX_UNSOLVED) {
            gameOver = true;
            return true;
        }
        return false;
    }
    
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
     * Helper method used to count how many times each room has been visited
     * 
     * @param r the room to count a visit for
     */
    private static void countVisits(Room r) {
        String key = r.getRoomName();
        if(visits.containsKey(key)) {
            visits.put(key, visits.get(key) + 1);
        } else {
            visits.put(key, 1);
        }
    }
    
    /*
     * A simple method to check all visited and unvisited rooms
     */
    public static void printVisitMap() {
        System.out.println("---------------- Dom's Map ----------------");
        System.out.println("Visited Rooms (visits):");
        for (Entry<String, Integer> entry : visits.entrySet()) {
            System.out.println("- " + entry.getKey() + " (" + entry.getValue() + ")");
        }
        System.out.println("-------------------------------------------\n");
    }

    /**
     * A Simple method to give a summary about time
     */
    public static void displayTimeSummary() {
        // Display time left before the owner returns
        System.out.println("\n----------- Dom's Time Summary ------------");
        System.out.println(clock.printTime());
        System.out.println("-------------------------------------------\n");
    }
    
    /**
     * This method prints the Game Over depending on why the game ended
     */
    public static void theEnd() {
        System.out.println("\n----------------- The End -----------------");
        if (hasCaughtGary) {
            System.out.println("CONGRATULATIONS, YOU HAVE WON!!! :)");
            System.out.println("DOM HAS CAUGHT GARY!!!");
        } else if (clock.getHours() == 0 && clock.getMinutes() == 0) {
            System.out.println("GAME OVER - YOU LOST! :(");
            System.out.println("Time has run out! Your owner has returned home, and Gary is still loose!");
        } else if (checkTraps()) {
            System.out.println("GAME OVER - YOU LOST! :(");
            System.out.println("Dom has been caught in too many traps and can't continue!");
        } else {
            System.out.println("Game Quit");
        }
        displayStats();
        printVisitMap();
    }

    /**
     * Method that prints game statics. Called in the end of game Summary
     */
    public static void displayStats() {
        System.out.println("------------- Game Statistics -------------");
        System.out.println(clock.printTime());
        System.out.println("Turns Forfeited: " + forfeits);
        System.out.println("Traps Encountered: " + trapsEncountered);
        System.out.println("Traps Solved: " + trapsSolved);
        System.out.println("Puzzles Encountered: " + puzzlesEncountered);
        System.out.println("Puzzles Solved: " + puzzlesSolved);
        System.out.println("Problems Encountered: " + problemsEncountered);
        System.out.println("Problems Best case: " + problemsSolved);
        System.out.println("Taunts Encountered: " + tauntsEncountered);
        System.out.println("Gary Encounters: " + GaryEncounters);
        System.out.println("Garys Caught: " + GarysCaught);
        //System.out.println("-------------------------------------------");
    }
}
