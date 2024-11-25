/**
 * Class: Living
 * 
 * Author: Group F CSE 201
 * 
 * This is child class of Room. This class is to implement one of the rooms 
 * in our game for the user to interact with. The room will provide scenarios and effects based
 * on user input.
 */

import java.util.Scanner;

/**
 * Child class of room that represents a Living room
 */
public class Living extends Room {
    /**
     * Constructor method for Bedroom
     */
    public Living() {
        super("Living");
    }

    /**
     * Gives options to get out of a trap set by Gary
     * 
     * @param sc System.in Scanner for user I/O
     */
    @Override
    public void trap(Scanner sc) {
        Game.trapsEncountered++;

        System.out.println("\nRoom description: The living room, where all of your owner's friends come n' go. It has a coffee table, TV, and 3 houseplants in it.");
        System.out.println("Situation: Gary made himself a trap that'll be set off as soon as you walk in.");
        System.out.println("-------------------------------------------");
        String user_input;
        boolean invalidChoice = false;

        do {
            invalidChoice = false;

            System.out.println("Enter the number that corresponds with how you want to enter the room:\n");
            System.out.println("1 -> Jump into the room");
            System.out.println("2 -> Crawl into the room");
            System.out.println("3 -> Walk in assuming the trap is elsewhere");
            System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");
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
                break;
            case "3":
                System.out.println("\nYou waltz in and proceed to step into several mousetraps.\n---\n");
                Game.clock.deductTime(5);
                break;
            case "4":
                System.out.println("\nYou chose to give up and forfeit this turn.\n---\n");
                Game.clock.deductTime(30);
                Game.forfeits++;
                break;
            default:
                System.out.println("\nInvalid choice! You remain trapped. Please enter 1, 2, 3, or 4");
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

        System.out.println("\nRoom description: The living room, where all of your owner's friends come n' go. It has a coffee table, TV, and 3 houseplants in it.");
        System.out.println("Situation: You realize that the television's remote is gone, and Gary hid it somewhere.");
        System.out.println("-------------------------------------------");
        String user_input;
        boolean invalidChoice = false;

        do {
            invalidChoice = false;

            System.out.println("Enter the number that corresponds with what objects you want to check:\n");
            System.out.println("1 -> Check in one of the houseplants");
            System.out.println("2 -> Check under the couch");
            System.out.println("3 -> Check behind the TV");
            System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");
            System.out.print("\nPlease enter your option: ");
            user_input = sc.nextLine().trim();

            switch (user_input) {
            case "1":
                System.out.println(
                        "\nYou dig into one of the houseplants and find nothing. There's dirt lying everywhere.\n---\n");
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
        
        System.out.println("\nRoom description: The living room, where all of your owner's friends come n' go. It has a coffee table, TV, and 3 houseplants in it.");
        System.out.println("Situation: As you come into the living room, you see several hot coffee cups on the verge of falling onto the carpet.");
        System.out.println("-------------------------------------------");
        String user_input;
        boolean invalidChoice = false;

        do {
            invalidChoice = false;

            System.out.println("Enter the number that corresponds with how you want to solve this problem:\n");
            System.out.println("1 -> Dive and save the cups before they fall onto the ground");
            System.out.println("2 -> Shove the cups back onto the table");
            System.out.println("3 -> Drink all of the coffee as it falls out");
            System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");
            System.out.print("\nPlease enter your option: ");
            user_input = sc.nextLine().trim();

            switch (user_input) {
            case "1":
                System.out.println("\nYou fly right below the cups, but the heat of the cups burns you. Coffee flies everywhere!\n---\n");
                Game.clock.deductTime(10);
                break;
            case "2":
                System.out.println("\nYou shove the coffee cups right as they're about to fall, but you shove it off the other side of the table.\n---\n");
                Game.clock.deductTime(10);
                break;
            case "3":
                System.out.println("\nYou yank all of the coffee cups and chug them. They taste good, too!\n---\n");
                Game.clock.deductTime(5);
                Game.problemsSolved++;
                break;
            case "4":
                System.out.println("\nYou chose to give up and forfeit this turn.\n---\n");
                Game.clock.deductTime(30);
                Game.forfeits++;
                break;
            default:
                System.out.println("\nInvalid choice! You remain trapped. Please enter 1, 2, 3, or 4");
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
        System.out.println("\nThere is a picture of Gary with his tougne out on the TV... You turn it off.\n---\n");
    }

    /**
     * If Gary is currently in the room, gives options to catch Gary and win the
     * game
     * 
     * @param sc System.in Scanner for user I/O
     */
    public void catchGary(Scanner sc) {
        Game.GaryEncounters++;
        
        System.out.println("\nRoom Description: The living room, where all of your owner's friends come n' go.");
        System.out.println("Situation: You walk in to see Gary watching cartoons!");
        System.out.println("-------------------------------------------");
        String userInput;
        boolean invalidChoice = false;

        do {
            invalidChoice = false;

            System.out.println("Enter the number that corresponds with what you want to do:\n");
            System.out.println("1 -> Jump onto the couch to grab him.");
            System.out.println("2 -> Lure him to you with cheese.");
            System.out.println("3 -> Run to the couch to grab him.");
            System.out.println("4 -> Give up and forfeit this turn, but keep in mind you will lose 30 minutes if you do so.");
            System.out.print("\nPlease enter your option: ");
            userInput = sc.nextLine().trim();

            switch (userInput) {
            case "1":
                System.out.println("\nGary is distracted my the show and doesnt see you coming so you grab him!\n---\n");
                Game.GarysCaught++;
                Game.hasCaughtGary = true;
                Game.gameOver = true;
                break;
            case "2":
                System.out.println("\nYou watch Gary pull cheese out of his pocket, then you realize your cheese is gone...\n---\n");
                Game.clock.deductTime(5);
                break;
            case "3":
                System.out.println("\nYou trip as the carpet pulls under you and Gary gets away.\n---\n");
                Game.clock.deductTime(5);
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
