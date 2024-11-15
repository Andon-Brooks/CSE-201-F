/**
 * Class: Office 
 * 
 * Author: Group F CSE 201
 * 
 * This is child class of Room. This class is to implement one of the rooms 
 * in our game for the user to interact with. The room will provide scenarios and effects based
 * on user input.
 */
import java.util.Scanner;

public class Office extends Room {
    
    /**
    * Constructor to build the room and pass the room name to the parent class.
    */
    public Office() {
        super("Office");
    }
    
    // Methods:
    /**
    * Creates the trap scenario for the user in the Office.
    * The player inputs a choice to escape the trap.
    * 
    * @param sc Scanner object for user input.
    */
    @Override
    public void trap(Scanner sc) {
        Game.trapsEncountered++;

        System.out.println("\nRoom Description: This is the office. It's filled with books, papers, and a computer.");
        System.out.println("Situation: Gary has set up a trap with a stack of books ready to fall on you!");
        System.out.println("-------------------------");
        String userInput;
        boolean invalidChoice = false;

        do {
            invalidChoice = false;

            System.out.println("How will you avoid the trap?\n");
            System.out.println("1 -> Carefully move around the books.");
            System.out.println("2 -> Jump over the books.");
            System.out.println("3 -> Try to remove the book at the bottom to defuse the trap.");
            System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");
            
            System.out.print("\nPlease enter your option: ");
            userInput = sc.nextLine().trim();
            
            switch(userInput) {
                case "1":
                    System.out.println("\nYou avoided the falling books, but it took a bit of time.\n---\n");
                    Game.clock.deductTime(5);
                    Game.unsolvedTraps++;
                    break;
                case "2":
                    System.out.println("\nYou successfully jumped over the trap!\n---\n");
                    Game.trapsSolved++;
                    break;
                case "3":
                    System.out.println("\nYou tried to remove the bottom book, but the whole stack fell on you!\n---\n");
                    Game.clock.deductTime(10);
                    Game.unsolvedTraps++;
                    break;
                case "4":
                    System.out.println("\nYou chose to give up and forfeit this turn.\n---\n");
                    Game.clock.deductTime(30);
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
     * Creates a puzzle scenario for the user in the Office.
     * The player inputs a choice to solve the puzzle.
     * 
     * @param sc Scanner object for user input.
     */
    @Override
    public void puzzle(Scanner sc) {
        Game.puzzlesEncountered++;

        System.out.println("\nRoom Description: This is the office. You notice a locked drawer in the desk.");
        System.out.println("Situation: Solve the riddle to unlock the drawer: 'I speak without a mouth and hear without ears. What am I?'");
        System.out.println("-------------------------");

        String userInput;
        boolean invalidChoice = false;

        do {
            invalidChoice = false;

            System.out.println("What is your answer?\n");
            System.out.println("1 -> An echo");
            System.out.println("2 -> A shadow");
            System.out.println("3 -> The wind");
            System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");

            System.out.print("\nPlease enter your option: ");
            userInput = sc.nextLine().trim();

            switch(userInput) {
                case "1":
                    System.out.println("\nCorrect! You unlocked the drawer and found some clues.\n---\n");
                    Game.puzzlesSolved++;
                    break;
                case "2":
                    System.out.println("\nIncorrect. That wasn't the answer.\n---\n");
                    Game.clock.deductTime(5);
                    break;
                case "3":
                    System.out.println("\nIncorrect. That wasn't the answer.\n---\n");
                    Game.clock.deductTime(5);
                    break;
                case "4":
                    System.out.println("\nYou chose to give up and forfeit this turn.\n---\n");
                    Game.clock.deductTime(30);
                    break;
                default:
                    System.out.println("\nInvalid choice. Please enter 1, 2, 3, or 4!");
                    System.out.println("-------------------------------------------\n");
                    invalidChoice = true;
            }
        } while (invalidChoice);
    }

    /**
     * Creates a problem scenario for the user in the Office.
     * The player chooses an option to solve the problem.
     * 
     * @param sc Scanner object for user input.
     */
    @Override
    public void problem(Scanner sc) {
        Game.problemsEncountered++;

        System.out.println("\nRoom Description: This is the office. The computer is on, and Gary has set it to play loud music.");
        System.out.println("Situation: You need to turn off the music before it alerts the neighbors.");
        System.out.println("-------------------------");

        String userInput;
        boolean invalidChoice = false;

        do {
            invalidChoice = false;

            System.out.println("How will you solve this problem?\n");
            System.out.println("1 -> Turn off the computer");
            System.out.println("2 -> Mute the speakers");
            System.out.println("3 -> Close the program playing the music");
            System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");

            System.out.print("\nPlease enter your option: ");
            userInput = sc.nextLine().trim();

            switch(userInput) {
                case "1":
                    System.out.println("\nYou turned off the computer, but it took some time to reboot.\n---\n");
                    Game.clock.deductTime(5);
                    break;
                case "2":
                    System.out.println("\nYou muted the speakers successfully and saved time.\n---\n");
                    break;
                case "3":
                    System.out.println("\nYou closed the program, but it wasn't very effective.\n---\n");
                    Game.clock.deductTime(5);
                    break;
                case "4":
                    System.out.println("\nYou chose to give up and forfeit this turn.\n---\n");
                    Game.clock.deductTime(30);
                    break;
                default:
                    System.out.println("\nInvalid choice. Please enter 1, 2, 3, or 4!");
                    System.out.println("-------------------------------------------\n");
                    invalidChoice = true;
            }
        } while (invalidChoice);
    }
    
    /**
     * Provides a taunt from Gary to the player, increasing the game's intensity.
     * 
     * @param sc Scanner object for user input.
     */
    @Override
    public void taunt(Scanner sc) {
        System.out.println("\nYou see a note from Gary: 'Catch me if you can, slowpoke!'\n---\n"); 
    }

    /**
     * Catches Gary in the Office and triggers the end game summary.
     * 
     * @param sc Scanner object for user input.
     */
    @Override
    public void catchGary(Scanner sc) {
        System.out.println("\nYou found Gary hiding in the office! You've caught him!\n---\n");
        Game.hasCaughtGary = true;
        Game.gameOver = true;
        Game.displayEndGameSummary();
    }
}
