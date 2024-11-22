/**
 * Class: Living Room 
 * 
 * @author: Group F CSE 201
 * 
 * This is a child class of Room. This class represents the living room in our game,
 * where players encounter unique scenarios and interact based on their choices.
 * The room offers various challenges such as traps, puzzles, and problems,
 * each affecting the game state differently.
 */
import java.util.Scanner;

public class Living extends Room {

    /**
     * Constructor to build the room and pass the room name to the parent class.
     */
    public Living() {
        super("Living");
    }
    
    /**
     * Creates the trap scenario for the user in the Living room.
     * The player selects an action to avoid a potential trap set by Gary.
     * 
     * @param sc Scanner object for user input.
     */
    @Override 
    public void trap(Scanner sc) {
        Game.trapsEncountered++;

        System.out.println("\nRoom description: The living room, where all of your owner's friends come n' go.");
        System.out.println("Gary doesn't come here too much, he doesn't want to get caught. It has a coffee table, TV, and 3 houseplants in it.");
        System.out.println("Situation: Gary made himself a trap that'll be set off as soon as you walk in."); 
        System.out.println("-------------------------");
        String user_input;
        boolean invalidChoice = false;
        
        do {
            invalidChoice = false;

            System.out.println("Enter the number that corresponds with how you want to enter the room:\n");
            System.out.println("1 <- Jump into the room");
            System.out.println("2 <- Crawl into the room");
            System.out.println("3 <- Walk in assuming the trap is elsewhere");

            System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");  // Forfeit option

            System.out.print("\nPlease enter your option: ");
            user_input = sc.nextLine().trim();
            
            switch (user_input) {
                case "1":
                    System.out.println("\nYou make it over the pile of mousetraps that are in front of the door.\n---\n");
                    Game.trapsSolved++;    
                    break;
                case "2":
                    System.out.println("\nYou crawl in, and your tail gets caught in one of the mousetraps.\n---\n");
                    Game.clock.deductTime(5);   
                    Game.unsolvedTraps++;
                    break;
                case "3":
                    System.out.println("\nYou waltz in and proceed to step into several mousetraps.\n---\n");
                    Game.clock.deductTime(5);   
                    Game.unsolvedTraps++;
                    break;
                case "4":
                    System.out.println("\nYou chose to give up and forfeit this turn.\n---\n");
                    Game.clock.deductTime(30); 
                    Game.unsolvedTraps++;
                    Game.forfeits++;    
                    break;
                default:
                    System.out.println("\nInvalid choice! You remain trapped. Please enter 1, 2, 3, or 4");
                    System.out.println("--------------------------------------------------------------\n");
                    invalidChoice = true;
            }

        if (Game.unsolvedTraps >= Game.MAX_UNSOLVED_TRAPS) {
            Game.gameOverTraps();
            return;
        }

        } while (invalidChoice);
    }

    /**
     * Creates a puzzle scenario for the user in the Living room.
     * The player will input their choice and to figure out the puzzle.
     *
     * @param sc Scanner object for user input.
     */
    @Override
    public void puzzle(Scanner sc) {
        Game.puzzlesEncountered++;  
        
        System.out.println("\nRoom description: The living room, where all of your owner's friends come n' go.");
        System.out.println("Gary doesn't come here too much, he doesn't want to get caught. It has a coffee table, TV, and 3 houseplants in it.");
        System.out.println("Situation: You realize that the television's remote is gone, and Gary hid it somewhere."); 
        System.out.println("-------------------------");
        String user_input;
        boolean invalidChoice = false;
        
        do {
            invalidChoice = false;

            System.out.println("Enter the number that corresponds with what objects you want to check:\n");
            System.out.println("1 <- Check in one of the houseplants");
            System.out.println("2 <- Check under the couch");
            System.out.println("3 <- Check behind the TV");

            System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");  // Forfeit option

            System.out.print("\nPlease enter your option: ");
            user_input = sc.nextLine().trim();

            switch (user_input) {
                case "1":
                    System.out.println("\nYou dig into one of the houseplants and find nothing. There's dirt lying everywhere.\n---\n");
                    Game.clock.deductTime(5);  
                    break;
                case "2":
                    System.out.println("\nYou find the remote wedged into the couch and take it out!\n---\n");
                    Game.puzzlesSolved++;  
                    break;
                case "3":
                    System.out.println("\nYou check behind the TV and accidentally knock it over.\n---\n");
                    Game.clock.deductTime(5);   
                    break;
                case "4":
                    System.out.println("\nYou chose to give up and forfeit this turn.\n---\n");
                    Game.clock.deductTime(30);  
                    Game.forfeits++;   
                    break;
                default:
                    System.out.println("\nInvalid choice! You remain trapped. Please enter 1, 2, 3, or 4");
                    System.out.println("--------------------------------------------------------------\n");
                    invalidChoice = true;
            }
        } while (invalidChoice);
    }

    /**
     * Creates a problem scenario for the user in the Kitchen.
     * The player must decide how to handle falling coffee cups to prevent further issues.
     * 
     * @param sc Scanner object for user input.
     */
    @Override
    public void problem(Scanner sc) {
        System.out.println("\nRoom description: The living room, where all of your owner's friends come n' go.");
        System.out.println("Gary doesn't come here too much, he doesn't want to get caught. It has a coffee table, TV, and 3 houseplants in it.");
        System.out.println("Situation: As you come into the living room, you see several hot coffee cups on the verge of falling onto the carpet."); 
        System.out.println("-------------------------");
        String user_input;
        boolean invalidChoice = false;

        Game.problemsEncountered++; 

        do {
            invalidChoice = false;

            System.out.println("Enter the number that corresponds with how you want to solve this problem:\n");
            System.out.println("1 <- Dive and save the cups before they fall onto the ground");
            System.out.println("2 <- Shove the cups back onto the table");
            System.out.println("3 <- Drink all of the coffee as it falls out");

            System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");  // Forfeit option

            System.out.print("\nPlease enter your option: ");
            user_input = sc.nextLine().trim();

            switch (user_input) {
                case "1":
                    System.out.println("\nYou fly right below the cups, but the heat of the cups burns you. Coffee flies everywhere!\n---\n");
                    Game.clock.deductTime(5);   
                    break;
                case "2":
                    System.out.println("\nYou shove the coffee cups right as they're about to fall, but you shove it off the other side of the table.\n---\n");
                    Game.clock.deductTime(5);   
                    break;
                case "3":
                    System.out.println("\nYou yank all of the coffee cups and chug them. They taste good, too!\n---\n");
                    break;
                case "4":
                    System.out.println("\nYou chose to give up and forfeit this turn.\n---\n");
                    Game.clock.deductTime(30);  
                    Game.forfeits++;    
                    break;
                default:
                    System.out.println("\nInvalid choice! You remain trapped. Please enter 1, 2, 3, or 4");
                    System.out.println("--------------------------------------------------------------\n");
                    invalidChoice = true;
            }
        } while (invalidChoice);
    }

    /**
     * Provides a taunt scenario for the user in the Living room.
     * The method prints a string of Gary trashtalking the user.
     *
     * @param sc Scanner object for user input.
     */
    @Override
    public void taunt(Scanner sc) {
        System.out.println("\nGary taunts you from another room!\n---\n");
    }
    
     /**
     * Catches Gary in the Living Room and triggers the end game summary.
     * 
     * @param sc Scanner object for user input.
     */
    @Override
    public void catchGary(Scanner sc) {

        System.out.println("\nYou found Gary in the living room! You've won the game!\n---\n");
        Game.hasCaughtGary = true;
        Game.gameOver = true;
        Game.displayEndGameSummary();
    }
}
