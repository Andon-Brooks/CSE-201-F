/**
 * Class: Kitchen 
 * 
 * Author: Group F CSE 201
 * 
 * This is child class of Room. This class is to implement one of the rooms 
 * in our game for the user to interact with. The room will provide scenarios and effects based
 * on user input.
 */

import java.util.Scanner;

/**
* Child class of room that represents a Kitchen
*/
public class Kitchen extends Room {
    /**
     * Constructor method for Kitchen
     */
    public Kitchen() {
        super("Kitchen");
    }

    /**
     * Gives options to get out of a trap set by Gary
     * 
     * @param sc System.in Scanner for user I/O
     */
    @Override
    public void trap(Scanner sc) {
        Game.trapsEncountered++;

        System.out.println("\nRoom Description: This room is the kitchen. The kitchen has a fridge, table and chairs, a pantry and sink.");
        System.out.println("Situation: There is a trap set in the kitchen, which option is the best to get around it?");
        System.out.println("-------------------------------------------");
        String userInput;
        boolean invalidChoice = false;

        do {
            invalidChoice = false;

            System.out.println("You fell into a trap in the kitchen!\n");
            System.out.println("1 -> Use a frying pan to hit the trap.");
            System.out.println("2 -> Run out of the room");
            System.out.println("3 -> Try to sneak out quietly.");
            System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");
            System.out.print("\nChoose how to escape: ");
            userInput = sc.nextLine().trim();

            switch (userInput) {
            case "1":
                System.out.println("\nYou hit the trap with the frying pan! It breaks open!\n---\n");
                Game.clock.deductTime(5);
                break;
            case "2":
                System.out.println("\nYou turn to run out of the rrom and slip on a bannana peel into the trap!\n---\n");
                Game.clock.deductTime(15);
                break;
            case "3":
                System.out.println("\nYou sneak out quietly and escape the trap!\n---\n");
                Game.trapsSolved++;
                break;
            case "4":
                System.out.println("\nYou chose to give up and forfeit this turn.\n---\n");
                Game.clock.deductTime(30);
                Game.forfeits++;
                break;
            default:
                System.out.println("\nInvalid choice! You remain trapped. Please enter 1, 2, 3, or 4!");
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
    public void puzzle(Scanner sc) {
        Game.puzzlesEncountered++;
        
        System.out.println("\nRoom Description: This room is the kitchen. The kitchen has a fridge, table and chairs, a pantry and sink.");
        System.out.println("Situation: The puzzle will give you extra time! Determine the order to find the clue based on the riddle.");
        System.out.println("First: Go to the guardian of meals, then to the storage of preserved secrets, then where remenants and water meet.");
        System.out.println("-------------------------------------------");
        String userInput;
        boolean invalidChoice = false;

        do {
            invalidChoice = false;

            System.out.println("Enter the number that corresponds with how you want to enter the room:\n");
            System.out.println("1 -> Sink, Fridge, Table");
            System.out.println("2 -> Pantry Sink, Fridge");
            System.out.println("3 -> Fridge, Pantry, Sink");
            System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");
            System.out.print("\nPlease enter your option: ");
            userInput = sc.nextLine().trim();

            switch (userInput) {
            case "1":
                System.out.println("\nIncorrect order, puzzle not solved.\n---\n");
                Game.clock.deductTime(5);
                break;
            case "2":
                System.out.println("\nPuzzle not solved! No bonus!\n---\n");
                Game.clock.deductTime(5);
                break;
            case "3":
                System.out.println("\nCorrect order! Puzzle Solved!\n---\n");
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
    public void problem(Scanner sc) {
        Game.problemsEncountered++;
        
        System.out.println("\nRoom Description: This room is the kitchen. The kitchen has a fridge, table and chairs, a pantry and sink.");
        System.out.println("Situation: Gary has caused a major problem! He has clogged the sink and unplugged the fridge!");
        System.out.println("-------------------------------------------");
        String userInput;
        boolean invalidChoice = false;
        
        do {
            invalidChoice = false;

            System.out.println("Enter the number that corresponds with how you want to handle the room's problems:\n");
            System.out.println("1 -> Unclog the sink first.");
            System.out.println("2 -> Plug in the fridge first.");
            System.out.println("3 -> Try to quickly plug in the fridge, then unclog the sink.");
            System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");
            System.out.print("\nPlease enter your option: ");
            userInput = sc.nextLine().trim();

            switch (userInput) {
            case "1":
                System.out.println("\nYou have successfully unclogged the sink, but the food in the fridge has started to warm up.\n---\n");
                Game.clock.deductTime(5);
                Game.problemsSolved++;
                break;
            case "2":
                System.out.println("\nYou plugged in the fridge, saving the food, but the clogged sink has caused water to overflow.\n---\n");
                Game.clock.deductTime(10);
                break;
            case "3":
                System.out.println("\nYou quickly plugged in the fridge and then unclogged the sink.");
                System.out.println("However, in your rush, you made a mess around the sink, costing you extra time to clean.\n---\n");
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
        System.out.println("\nYou find a drawing on the fridge with Gary's signature at the bottom of you outside with a frown.\n---\n");
    }

    /**
     * If Gary is currently in the room, gives options to catch Gary and win the
     * game
     * 
     * @param sc System.in Scanner for user I/O
     */
    public void catchGary(Scanner sc) {
        Game.GaryEncounters++;
        
        System.out.println("\nRoom Description: This room is the kitchen. The kitchen has a fridge, table and chairs, a pantry and sink.");
        System.out.println("Situation: You find Gary digging through the food in the fridge!");
        System.out.println("-------------------------------------------");
        String userInput;
        boolean invalidChoice = false;

        do {
            invalidChoice = false;

            System.out.println("Enter the number that corresponds with what you want to do:\n");
            System.out.println("1 -> Close the fridge door, trapping Gary.");
            System.out.println("2 -> Reach in the fridge to grab him.");
            System.out.println("3 -> Hide beside the fridge and wait for him to come out.");
            System.out.println("4 -> Give up and forfeit this turn, but keep in mind you will lose 30 minutes if you do so.");
            System.out.print("\nPlease enter your option: ");
            userInput = sc.nextLine().trim();

            switch (userInput) {
            case "1":
                System.out.println("\nYou trap Gary but the next time you open the fridge he runs away leaving a mess for you to clean!\n---\n");
                Game.clock.deductTime(20);
                break;
            case "2":
                System.out.println("\nYou reach in the fridge and Gary puts a mousetrap to your hand and escapes!\n---\n");
                Game.clock.deductTime(5);
                break;
            case "3":
                System.out.println("\nGary keeps eating until he slowly comes out adn you grab him!\n---\n");
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
