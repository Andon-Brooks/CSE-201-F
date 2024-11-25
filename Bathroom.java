/**
 * Class: Bathroom 
 * 
 * Author: Group F CSE 201
 * 
 * This is child class of Room. This class is to implement one of the rooms 
 * in our game for the user to interact with. The room will provide scenarios and effects based
 * on user input.
 */

import java.util.Scanner;

/**
* Child class of room that represents a Bathroom
*/
public class Bathroom extends Room {
    /**
     * Constructor method for Bathroom
     */
    public Bathroom() {
        super("Bathroom");
    }

    /**
     * Gives options to get out of a trap set by Gary
     * 
     * @param sc System.in Scanner for user I/O
     */
    @Override
    public void trap(Scanner sc) {
        Game.trapsEncountered++;

        System.out.println("\nRoom Description: This is the bathroom. The floor is slippery and scattered with bath toys.");
        System.out.println("Situation: Gary has left marbles on the floor as a trap.");
        System.out.println("-------------------------------------------");
        String userInput;
        boolean invalidChoice = false;

        do {
            invalidChoice = false;

            System.out.println("Enter the number that corresponds with how you want to avoid the trap:\n");
            System.out.println("1 -> Carefully tiptoe around the marbles.");
            System.out.println("2 -> Slide across the floor to avoid stepping on marbles.");
            System.out.println("3 -> Try to pick up all the marbles.");
            System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");
            System.out.print("\nPlease enter your option: ");
            userInput = sc.nextLine().trim();

            switch (userInput) {
            case "1":
                System.out.println("\nYou did not manage to tiptoe around the marbles safely. You fell!\n---\n");
                Game.clock.deductTime(5);
                break;
            case "2":
                System.out.println("\nYou slid across the floor and avoided the marbles!\n---\n");
                Game.trapsSolved++;
                break;
            case "3":
                System.out.println("\nYou tried to pick up the marbles, but it took more time than expected.\n---\n");
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
     * Gives options to solve a puzzle set by Gary
     * 
     * @param sc System.in Scanner for user I/O
     */
    @Override
    public void puzzle(Scanner sc) {
        Game.puzzlesEncountered++;

        System.out.println("\nRoom Description: This is the bathroom. There's a riddle written on the mirror.");
        System.out.println("Situation: The riddle says, 'I am wetter the more I dry, What am I?'");
        System.out.println("-------------------------------------------");
        String userInput;
        boolean invalidChoice = false;

        do {
            invalidChoice = false;

            System.out.println("Enter the number that corresponds with where you think the answer lies:\n");
            System.out.println("1 -> The bathtub");
            System.out.println("2 -> The toilet");
            System.out.println("3 -> The bath towel");
            System.out.println("4 -> Give up and forfeit this turn, but keep in mind you will lose 30 minutes if you do so.");
            System.out.print("\nPlease enter your option: ");
            userInput = sc.nextLine().trim();

            switch (userInput) {
            case "1":
                System.out.println("\nThe bathtub was empty. Time wasted.\n---\n");
                Game.clock.deductTime(5);
                break;
            case "2":
                System.out.println("\nThe toilet was empty. Time wasted.\n---\n");
                Game.clock.deductTime(5);
                break;
            case "3":
                System.out.println("\nCorrect! The towel was the answer.\n---\n");
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
        
        System.out.println("\nRoom Description: This is the bathroom. It's steamy, and water is splashing everywhere.");
        System.out.println("Situation: Gary has left the shower running, and the floor is covered in water.");
        System.out.println("-------------------------------------------");
        String userInput;
        boolean invalidChoice = false;

        do {
            invalidChoice = false;

            System.out.println("Enter the number that corresponds with how you want to handle this problem:\n");
            System.out.println("1 -> Turn off the shower.");
            System.out.println("2 -> Wipe up the water.");
            System.out.println("3 -> Both turn off the shower and wipe up the water.");
            System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");
            System.out.print("\nPlease enter your option: ");
            userInput = sc.nextLine().trim();

            switch (userInput) {
            case "1":
                System.out.println("\nYou turned off the shower, but the floor is still wet.\n---\n");
                Game.clock.deductTime(5);
                Game.problemsSolved++;
                break;
            case "2":
                System.out.println("\nYou wiped up the water, but the shower is still running.\n---\n");
                Game.clock.deductTime(10);
                break;
            case "3":
                System.out.println("\nYou turned off the shower and wiped up the water, but it has taken time away. Problem solved though!\n---\n");
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
        System.out.println("\nGary left a message on the mirror: 'You'll never catch me!'\n---\n");
    }

    /**
     * If Gary is currently in the room, gives options to catch Gary and win the
     * game
     * 
     * @param sc System.in Scanner for user I/O
     */
    public void catchGary(Scanner sc) {
        Game.GaryEncounters++;
        
        System.out.println("\nRoom Description: This is the bathroom.");
        System.out.println("Situation: You see Gary in the bathtub.");
        System.out.println("-------------------------------------------");
        String userInput;
        boolean invalidChoice = false;

        do {
            invalidChoice = false;

            System.out.println("Enter the number that corresponds with what you want to do:\n");
            System.out.println("1 -> Jump to Grab him");
            System.out.println("2 -> Close the Bathroom Door");
            System.out.println("3 -> Throw a towel over him");
            System.out.println("4 -> Give up and forfeit this turn, but keep in mind you will lose 30 minutes if you do so.");
            System.out.print("\nPlease enter your option: ");
            userInput = sc.nextLine().trim();

            switch (userInput) {
            case "1":
                System.out.println("\nHe quickly runs out of the room before you get to him.\n---\n");
                Game.clock.deductTime(5);
                break;
            case "2":
                System.out.println("\nGary Escapes through his mouse tunnels.\n---\n");
                Game.clock.deductTime(5);
                break;
            case "3":
                System.out.println("\nGary gets stuck in the towel and you are able to grab him\n---\n");
                Game.GarysCaught++;
                Game.hasCaughtGary = true;
                Game.gameOver = true;
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
