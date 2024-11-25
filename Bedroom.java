/**
 * Class: Bedroom 
 * 
 * Author: Group F CSE 201
 * 
 * This is child class of Room. This class is to implement one of the rooms 
 * in our game for the user to interact with. The room will provide scenarios and effects based
 * on user input.
 */

import java.util.Scanner;

/**
 * Child class of room that represents a Bedroom
 */
public class Bedroom extends Room {
    /**
     * Constructor method for Bedroom
     */
    public Bedroom() {
        super("Bedroom");
    }
    
    /**
     * Gives options to get out of a trap set by Gary
     * 
     * @param sc System.in Scanner for user I/O
     */
    @Override
    public void trap(Scanner sc) {
        Game.trapsEncountered++; 
        
        System.out.println("\nRoom Description: This room is the bedroom. The bedroom is quiet. It contains a bed and a dresser.");
        System.out.println("Situation: Gary has placed a trap to deploy when you walk in, how do you want to enter the room?");
        System.out.println("-------------------------------------------");
        String userInput;
        boolean invalidChoice = false;

        do {
            invalidChoice = false;

            System.out.println("Enter the number that corresponds with how you want to enter the room:\n");
            System.out.println("1 -> Crawl into the room to avoid any swinging objects");
            System.out.println("2 -> Swing into the room to avoid a trap that could be placed on the ground");
            System.out.println("3 -> Walk in normally assuming trap is elsewhere in the room");
            System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");
            System.out.print("\nPlease enter your option: ");
            userInput = sc.nextLine().trim();

            switch (userInput) {
            case "1":
                System.out.println("\nYou have been hit by a swinging ball attached to the top of the door.\n---\n");
                Game.clock.deductTime(10);
                break;
            case "2":
                System.out.println("\nYou have successfully avoided the marbles in front of the door by swinging into the room.\n---\n");
                Game.trapsSolved++;
                break;
            case "3":
                System.out.println("\nYou have been hit by a swinging ball attached to the top of the door.\n---\n");
                Game.clock.deductTime(10);
                break;
            case "4":
                System.out.println("\nYou chose to give up and forfeit this turn.\n---\n");
                Game.clock.deductTime(30);
                Game.forfeits++;
                break;
            default:
                System.out.println("\nInvalid choice. Please enter 1, 2, 3, or 4!");
                System.out.println("-------------------------------------------\n");
                invalidChoice = true;
            }
        } while (invalidChoice);
    }
    
    /**
     * Gives options to solve a puzzle set by Gary
     * 
     * @param sc System.in Scanner for user I/O
     */
    @Override
    public void puzzle(Scanner sc) {
        Game.puzzlesEncountered++;

        System.out.println("\nRoom Description: This room is the bedroom. The bedroom is quiet. It contains a bed and a dresser.");
        System.out.println("Situation: Find the hidden mess, what a distress, the mess would be where you find a dress?");
        System.out.println("-------------------------------------------");
        String userInput;
        boolean invalidChoice = false;

        do {
            invalidChoice = false;

            System.out.println("Enter the number that corresponds with how you want to enter the room:\n");
            System.out.println("1 -> Container under the bed");
            System.out.println("2 -> Hanging on the door");
            System.out.println("3 -> In the dresser");
            System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");
            System.out.print("\nPlease enter your option: ");
            userInput = sc.nextLine().trim();

            switch (userInput) {
            case "1":
                System.out.println("\nYou did not find the mess.\n---\n");
                Game.clock.deductTime(5);
                break;
            case "2":
                System.out.println("\nYou did not find the mess.\n---\n");
                Game.clock.deductTime(5);
                break;
            case "3":
                System.out.println("\nCorrect, the dresser is where the mess is. You have saved time.\n---\n");
                Game.puzzlesSolved++;
                break;
            case "4":
                System.out.println("\nYou chose to give up and forfeit this turn.\n---\n");
                Game.clock.deductTime(30);
                Game.forfeits++;
                break;
            default:
                System.out.println("\nInvalid choice. Please enter 1, 2, 3, or 4!");
                System.out.println("-------------------------------------------\n");
                invalidChoice = true;
            }
        } while (invalidChoice);
    }

    /**
     * Gives options to handle a trap set by Gary
     * 
     * @param sc System.in Scanner for user I/O
     */
    @Override
    public void problem(Scanner sc) {
        Game.problemsEncountered++;        
        
        System.out.println("\nRoom Description: This room is the bedroom. The bedroom is quiet. It contains a bed, tv and a dresser.");
        System.out.println("Situation: Gary has been up to no good. The TV is hanging off the edge of the dresser and Gary has opened the window and birds are sitting on the seal.");
        System.out.println("-------------------------------------------");
        String userInput;
        boolean invalidChoice = false;

        do {
            invalidChoice = false;

            System.out.println("Enter the number that corresponds with how you want to enter the room\n");
            System.out.println("1 -> Fix the TV so it is will not fall");
            System.out.println("2 -> Close the window to prevent birds from coming in the bedroom");
            System.out.println("3 -> Try to distract the birds and fix the TV, then close the window");
            System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");
            System.out.print("\nPlease enter your option: ");
            userInput = sc.nextLine().trim();

            switch (userInput) {
            case "1":
                System.out.println("\nYou have stopped the TV from falling, although the birds have entered the room.\n---\n");
                Game.clock.deductTime(5);
                Game.problemsSolved++;
                break;
            case "2":
                System.out.println("\nYou have sucessfully gotten the birds out and close the window, however the TV has shattered.\n---\n");
                Game.clock.deductTime(10);
                break;
            case "3":
                System.out.println("\nYou tried to throw a shoe at the birds. The birds were scared off, doing so you made it to the TV, then closed the window.");
                System.out.println("However, you broke the lamp with the shoe, now you have lost time in cleaning up the mess you made.\n---\n");
                Game.clock.deductTime(15);
                break;
            case "4":
                System.out.println("\nYou chose to give up and forfeit this turn.\n---\n");
                Game.clock.deductTime(30);
                Game.forfeits++;
                break;
            default:
                System.out.println("\nInvalid choice. Please enter 1, 2, 3, or 4!");
                System.out.println("-------------------------------------------\n");
                invalidChoice = true;
            }
        } while (invalidChoice);
    }

    /**
     * Prints a taunt message from Gary
     * 
     * @param sc System.in Scanner for user I/O
     */
    @Override
    public void taunt(Scanner sc) {
        Game.tauntsEncountered++;
        System.out.println("\nA note was left on the bed saying, 'HAHAHAHAHA - Gary ;)'\n---\n");
    }

    /**
     * If Gary is currently in the room, gives options to catch Gary and win the
     * game
     * 
     * @param sc System.in Scanner for user I/O
     */
    public void catchGary(Scanner sc) {
        Game.GaryEncounters++;
        
        System.out.println("\nRoom Description: This room is the bedroom. The bedroom is quiet. It contains a bed, tv and a dresser.");
        System.out.println("Situation: You see Gary laying on the bed relaxing.");
        System.out.println("-------------------------------------------");
        String userInput;
        boolean invalidChoice = false;

        do {
            invalidChoice = false;

            System.out.println("Enter the number that corresponds with what you want to do:\n");
            System.out.println("1 -> Jump to Grab him");
            System.out.println("2 -> Slowly crawl to the bed then grab him");
            System.out.println("3 -> Trap him in the blanket");
            System.out.println("4 -> Give up and forfeit this turn, but keep in mind you will lose 30 minutes if you do so.");
            System.out.print("\nPlease enter your option: ");
            userInput = sc.nextLine().trim();

            switch (userInput) {
            case "1":
                System.out.println("\nHe quickly runs out of the room before you get to him.\n---\n");
                Game.clock.deductTime(5);
                break;
            case "2":
                System.out.println("\nGary Doesn't see you coming and you are able to grab him!.\n---\n");
                Game.GarysCaught++;
                Game.hasCaughtGary = true;
                Game.gameOver = true;
                break;
            case "3":
                System.out.println("\nYou get twisted in the blanket and Gary escapes!\n---\n");
                Game.clock.deductTime(15);
                break;
            case "4":
                System.out.println("\nYou chose to give up and forfeit this turn. Gary Escapes.\n---\n");
                Game.clock.deductTime(30);
                Game.forfeits++;
                break;
            default:
                System.out.println("\nInvalid choice. Please enter 1, 2, 3, or 4!");
                System.out.println("-------------------------------------------\n");
                invalidChoice = true;
            }
        } while (invalidChoice);
    }
}
