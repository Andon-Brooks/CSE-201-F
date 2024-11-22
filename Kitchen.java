/**
 * Class: Kitchen 
 * 
 * @author: Group F CSE 201
 * 
 * This is a child class of Room. This class represents the kitchen in our game,
 * where players encounter unique scenarios and interact based on their choices.
 * The room offers various challenges such as traps, puzzles, and problems,
 * each affecting the game state differently.
 */

import java.util.Scanner;

public class Kitchen extends Room {

    /**
     *  Constructor to build the room and pass the room name to the parent class.
     */
    public Kitchen() {
        super("Kitchen"); // Pass "Kitchen" to the Room constructor
    }

    /**
     * Creates the trap scenario for the user in the Kitchen.
     * The player selects an action to avoid a potential trap set by Gary.
     * 
     * @param sc Scanner object for user input.
     */
    @Override
    public void trap(Scanner sc) {
        Game.trapsEncountered++;

        System.out.println("\nRoom Description: This room is the kitchen. The kitchen has a fridge, table and chairs, a pantry and sink.");
        System.out.println("Situation: There is a trap set in the kitchen, where option is the best to get around it?");
        System.out.println("-------------------------");


        String userInput;
        boolean invalidChoice = false;

        do {
            invalidChoice = false;

            System.out.println("You fell into a trap in the kitchen!\n");
            System.out.println("1. Use a frying pan to hit the trap.");
            System.out.println("2. Call for help.");
            System.out.println("3. Try to sneak out quietly.");

            System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");  // Forfeit option

            System.out.print("\nChoose how to escape: ");
            userInput = sc.nextLine().trim();

            switch (userInput) {
            case "1":
                System.out.println("\nYou hit the trap with the frying pan! It breaks open!\n---\n");
                Game.clock.deductTime(5);   
                Game.unsolvedTraps++;
                break;
            case "2":
                System.out.println("\nYou call for help, but no one hears you.\n---\n");
                Game.clock.deductTime(5);   
                Game.unsolvedTraps++;
                break;
            case "3":
                System.out.println("\nYou sneak out quietly and escape the trap!\n---\n");
                Game.trapsSolved++;     
                break;
            case "4":
                System.out.println("\nYou chose to give up and forfeit this turn.\n---\n");
                Game.clock.deductTime(30);  
                Game.forfeits++;   
                Game.unsolvedTraps++;
                break;
            default:
                System.out.println("\nInvalid choice! You remain trapped. Please enter 1, 2, 3, or 4!");
                System.out.println("---------------------------------------------------------------\n");
                invalidChoice = true;
            }

        if (Game.unsolvedTraps >= Game.MAX_UNSOLVED_TRAPS) {
            Game.gameOverTraps();
            return;
        }

        } while(invalidChoice);
    }

    /**
     * Creates a problem scenario for the user in the Kitchen.
     * The player selects an option to address the issue of a clogged sink and an unplugged fridge.
     * 
     * @param sc Scanner object for user input.
     */
    public void problem(Scanner sc){
        System.out.println("\nRoom Description: This room is the kitchen. The kitchen has a fridge, table and chairs, a pantry and sink.");
        System.out.println("Situation: Gary has caused a major problem! He has clogged the sink and unplugged the fridge!");
        System.out.println("-------------------------");
        
        String userInput; 
        boolean invalidChoice = false;

        Game.problemsEncountered++;     
        
        do {
            invalidChoice = false;

           System.out.println("Enter the number that corresponds with how you want to handle the room's problems:\n");
           System.out.println("1 -> Unclog the sink first.");
           System.out.println("2 -> Plug in the fridge first.");
           System.out.println("3 -> Try to quickly plug in the fridge, then unclog the sink.");
           
           System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");   // Forfeit option

           System.out.print("\nPlease enter your option: ");
           userInput = sc.nextLine().trim();
           
           switch(userInput){
                case "1":
                    System.out.println("\nYou have successfully unclogged the sink, but the food in the fridge has started to warm up.\n---\n");
                    Game.clock.deductTime(5);  
                    break;
                case "2":
                    System.out.println("\nYou plugged in the fridge, saving the food, but the clogged sink has caused water to overflow.\n---\n");
                    Game.clock.deductTime(5);   
                    break;
                case "3":
                    System.out.println("\nYou quickly plugged in the fridge and then unclogged the sink.");
                    System.out.println("However, in your rush, you made a mess around the sink, costing you extra time to clean.\n---\n");
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
        
        } while(invalidChoice);
    }
    
    /**
     * Creates a puzzle scenario for the user in the Kitchen.
     * The player will input their choice and to figure out the puzzle.
     *
     * @param sc Scanner object for user input.
     */
    public void puzzle(Scanner sc){
        Game.puzzlesEncountered++;  
        
        System.out.println("\nRoom Description: This room is the kitchen. The kitchen has a fridge, table and chairs, a pantry and sink.");
        System.out.println("Situation: The puzzle will give you extra time! Determine the order to find the clue based on the riddle.");
        System.out.println("First: Go to the guardian of meals, then to the storage of preserved secrets, then where remenants and water meet.");
        System.out.println("-------------------------");
        
        String userInput; 
        boolean invalidChoice = false;
        
        do {
            invalidChoice = false;

           System.out.println("Enter the number that corresponds with how you want to enter the room:\n");
           System.out.println("1 -> Sink, Fridge, Table");
           System.out.println("2 -> Pantry Sink, Fridge");
           System.out.println("3 -> Fridge, Pantry, Sink");
           
           System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");   // Forfeit option

           System.out.print("\nPlease enter your option: ");
           userInput = sc.nextLine().trim();
           
           switch(userInput){
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
        } while(invalidChoice);
    }

    /**
     * Provides a taunt scenario for the user in the Kitchen.
     * The method prints a string of Gary trashtalking the user.
     *
     * @param sc Scanner object for user input.
     */
    @Override
    public void taunt(Scanner sc) {
        System.out.println("\nGary taunts you from another room!\n---\n");
    }

     /**
     * Catches Gary in the Kitchen and triggers the end game summary.
     * 
     * @param sc Scanner object for user input.
     */
    @Override
    public void catchGary(Scanner sc){
        System.out.println("\nGary is in the kitchen! Dom caught him just in time!\n---\n");
        Game.hasCaughtGary = true;
        Game.gameOver = true;
        Game.displayEndGameSummary();
    }
}
