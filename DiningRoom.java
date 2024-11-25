/**
 * Class: DiningRoom
 * 
 * @author: Group F CSE 201
 * 
 * This is a child class of Room. This class represents the dining room in our game,
 * where players encounter unique scenarios and interact based on their choices.
 * The room offers various challenges such as traps, puzzles, and problems,
 * each affecting the game state differently.
 */
import java.util.Scanner;
/*
* Child class of room to represent a DiningROom
*/
public class DiningRoom extends Room {

    /**
     * Constructor to build the room and pass the room name to the parent class.
     */
    public DiningRoom() {
        super("DiningRoom");
    }
    
    /**
     * Creates the trap scenario for the user in the Dining Room.
     * The player inputs a choice to avoid the falling chandelier trap.
     * 
     * @param sc Scanner object for user input.
     */
    @Override
    public void trap(Scanner sc) {
        Game.trapsEncountered++;

        System.out.println("\nRoom Description: The dining room has a long table with chairs around it, and a chandelier above.");
        System.out.println("Situation: Gary has loosened the screws on the chandelier above the table. It might fall any moment!");
        System.out.println("-------------------------");

        String userInput;
        boolean invalidChoice = false;

        do {
            invalidChoice = false;

            System.out.println("Enter the number that corresponds with how you want to avoid the trap:\n");
            System.out.println("1 -> Crawl under the table to avoid the chandelier.");
            System.out.println("2 -> Carefully walk around the edges of the room.");
            System.out.println("3 -> Try to quickly fix the screws on the chandelier.");
            System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");

            System.out.print("\nPlease enter your option: ");
            userInput = sc.nextLine().trim();

            switch (userInput) {
                case "1":
                    System.out.println("\nYou crawled under the table and avoided the falling chandelier.\n---\n");
                    Game.trapsSolved++;
                    break;
                case "2":
                    System.out.println("\nYou carefully walked around the room, but it took some extra time.\n---\n");
                    Game.clock.deductTime(5);
                    Game.unsolvedTraps++;
                    break;
                case "3":
                    System.out.println("\nYou tried to fix the chandelier, but it fell anyway!\n---\n");
                    Game.clock.deductTime(10);
                    Game.unsolvedTraps++;
                    break;
                case "4":
                    System.out.println("\nYou chose to give up and forfeit this turn.\n---\n");
                    Game.clock.deductTime(30);
                    Game.forfeits++;
                    Game.unsolvedTraps++;
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
     * Creates a puzzle scenario for the user in the Dining Room.
     * The player inputs a choice to solve the puzzle involving a table arrangement.
     * 
     * @param sc Scanner object for user input.
     */
    @Override
    public void puzzle(Scanner sc) {
        Game.puzzlesEncountered++;

        System.out.println("\nRoom Description: The dining room has a large table set for a feast.");
        System.out.println("Situation: A note on the table reads, 'To find your prize, align the items on the table as they would be during a royal dinner.'");
        System.out.println("-------------------------");

        String userInput;
        boolean invalidChoice = false;

        do {
            invalidChoice = false;

            System.out.println("Enter the number that corresponds with how you want to arrange the items:\n");
            System.out.println("1 -> Plates on the left, glasses on the right.");
            System.out.println("2 -> Glasses on the left, plates on the right.");
            System.out.println("3 -> Both plates and glasses in the center.");
            System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");

            System.out.print("\nPlease enter your option: ");
            userInput = sc.nextLine().trim();

            switch (userInput) {
                case "1":
                    System.out.println("\nCorrect! You solved the puzzle and found a small key hidden under a plate.\n---\n");
                    Game.puzzlesSolved++;
                    break;
                case "2":
                    System.out.println("\nIncorrect arrangement. Try again next time.\n---\n");
                    Game.clock.deductTime(5);
                    break;
                case "3":
                    System.out.println("\nThe arrangement was wrong, and it wasted some time.\n---\n");
                    Game.clock.deductTime(5);
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
     * Creates a problem scenario for the user in the Dining Room.
     * The player chooses an option to handle the spilled soup problem.
     * 
     * @param sc Scanner object for user input.
     */
    @Override
    public void problem(Scanner sc) {
        Game.problemsEncountered++;

        System.out.println("\nRoom Description: The dining room is filled with a delicious aroma, but something seems off.");
        System.out.println("Situation: Gary has overturned a bowl of soup, and it's spilling all over the tablecloth!");
        System.out.println("-------------------------");

        String userInput;
        boolean invalidChoice = false;

        do {
            invalidChoice = false;

            System.out.println("Enter the number that corresponds with how you want to handle this problem:\n");
            System.out.println("1 -> Wipe up the soup with a napkin.");
            System.out.println("2 -> Replace the tablecloth.");
            System.out.println("3 -> Place the bowl upright and clean the spill.");
            System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");

            System.out.print("\nPlease enter your option: ");
            userInput = sc.nextLine().trim();

            switch (userInput) {
                case "1":
                    System.out.println("\nYou wiped up the soup, but it took up some time.\n---\n");
                    Game.clock.deductTime(10);
                    break;
                case "2":
                    System.out.println("\nYou replaced the tablecloth, but it took up some time.\n---\n");
                    Game.clock.deductTime(10);
                    break;
                case "3":
                    System.out.println("\nYou fixed the spill quickly.\n---\n");
                    Game.clock.deductTime(5);
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
     * Provides a taunt scenario for the user in the Dining Room.
     * Gary mocks the player with a clue about his location.
     * 
     * @param sc Scanner object for user input.
     */
    @Override
    public void taunt(Scanner sc) {
        System.out.println("\nGary left a crumb trail to mock you, hinting he's hiding somewhere else!\n---\n");
    }
  
    /**
     * Catches Gary in the Dining Room and triggers the end game summary.
     * 
     * @param sc Scanner object for user input.
     */
    @Override
    public void catchGary(Scanner sc) {
        System.out.println("\nGary is hiding under the dining table! You've caught him!\n---\n");
        Game.hasCaughtGary = true;
        Game.gameOver = true;
        Game.displayEndGameSummary();
    }
}
