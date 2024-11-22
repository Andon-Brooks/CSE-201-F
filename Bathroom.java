/**
 * Class: Bathroom
 * 
 * @author: Group F CSE 201
 * 
 * This is a child class of Room. This class represents the bathroom in our game,
 * where players encounter unique scenarios and interact based on their choices.
 * The room offers various challenges such as traps, puzzles, and problems,
 * each affecting the game state differently.
 */
import java.util.Scanner;

/*
* Child class of room that represents a bathroom
*/
public class Bathroom extends Room {
    
    /**
     * Constructor to build the room and pass the room name to the parent class.
     */
    public Bathroom() {
        super("Bathroom");
    }

    /**
     * Creates a problem scenario for the user in the Bathroom.
     * The player chooses an option to handle a running shower and a wet floor.
     * 
     * @param sc Scanner object for user input.
     */
    @Override
    public void problem(Scanner sc) {
        System.out.println("\nRoom Description: This is the bathroom. It's steamy, and water is splashing everywhere.");
        System.out.println("Situation: Gary has left the shower running, and the floor is covered in water.");
        System.out.println("-------------------------");
        
        String userInput;
        boolean invalidChoice = false;

        Game.problemsEncountered++;
        
        do {
            invalidChoice = false;

            System.out.println("Enter the number that corresponds with how you want to handle this problem:\n");
            System.out.println("1 -> Turn off the shower.");
            System.out.println("2 -> Wipe up the water.");
            System.out.println("3 -> Both turn off the shower and wipe up the water.");

            System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");

            System.out.print("\nPlease enter your option: ");
            userInput = sc.nextLine().trim();
            
            switch(userInput) {
                case "1":
                    System.out.println("\nYou turned off the shower, but the floor is still wet.\n---\n");
                    Game.clock.deductTime(5);
                    break;
                case "2":
                    System.out.println("\nYou wiped up the water, but the shower is still running.\n---\n");
                    Game.clock.deductTime(5);
                    break;
                case "3":
                    System.out.println("\nYou turned off the shower and wiped up the water, but it has taken time away. Problem solved though!\n---\n");
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
     * Creates the trap scenario for the user in the Bathroom.
     * The player inputs a choice to avoid slipping on a floor covered with marbles.
     * 
     * @param sc Scanner object for user input.
     */
    @Override
    public void trap(Scanner sc) {
        Game.trapsEncountered++;
        
        System.out.println("\nRoom Description: This is the bathroom. The floor is slippery and scattered with bath toys.");
        System.out.println("Situation: Gary has left marbles on the floor as a trap.");
        System.out.println("-------------------------");
        
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
            
            switch(userInput) {
                case "1":
                    System.out.println("\nYou did not manage to tiptoe around the marbles safely. You fell!\n---\n");
                    Game.clock.deductTime(5);
                    Game.unsolvedTraps++;
                    break;
                case "2":
                    System.out.println("\nYou slid across the floor and avoided the marbles!\n---\n");

                    Game.trapsSolved++;

                    break;
                case "3":
                    System.out.println("\nYou tried to pick up the marbles, but it took more time than expected.\n---\n");
                    Game.clock.deductTime(15);
                    Game.unsolvedTraps++;
                    break;

                case "4":
                    System.out.println("\nYou chose to give up and forfeit this turn.\n---\n");
                    Game.clock.deductTime(30);
                    Game.unsolvedTraps++;
                    Game.forfeits++;
                    break;

                default:
                    System.out.println("\nInvalid choice. Please enter 1, 2, 3, or 4!");
                    System.out.println("-------------------------------------------\n");
                    invalidChoice = true;
            }

        if (Game.unsolvedTraps >= Game.MAX_UNSOLVED_TRAPS) {
            Game.gameOverTraps();
            return;
        }

        } while (invalidChoice);
    }
    
    /**
     * Creates a puzzle scenario for the user in the Bathroom.
     * The player inputs a choice to solve the riddle written on the bathroom mirror.
     * 
     * @param sc Scanner object for user input.
     */
    @Override
    public void puzzle(Scanner sc) {
        Game.puzzlesEncountered++;
        
        System.out.println("\nRoom Description: This is the bathroom. There's a riddle written on the mirror.");
        System.out.println("Situation: The riddle says, 'I am wetter the more I dry, What am I?'");
        System.out.println("-------------------------");
        
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
            
            switch(userInput) {
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

                    Game.clock.addTime(5);
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
     * Provides a taunt scenario for the user in the Bathroom.
     * Gary mocks the player with a message written on the mirror.
     * 
     * @param sc Scanner object for user input.
     */
    @Override
    public void taunt(Scanner sc) {
        System.out.println("\nGary left a message on the mirror: 'You'll never catch me in time!'\n---\n");
    }
    
    /**
     * Catches Gary in the Bathroom and triggers the end game summary.
     * 
     * @param sc Scanner object for user input.
     */
    @Override
    public void catchGary(Scanner sc) {
        System.out.println("\nGary was hiding behind the shower curtain! You caught him!\n---\n");
        Game.hasCaughtGary = true;
        Game.gameOver = true;
        Game.displayEndGameSummary();
    }

}
