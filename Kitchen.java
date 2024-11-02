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

public class Kitchen extends Room {

    /**
     * Constructor to build the room.
     */
    public Kitchen() {
        super("Kitchen"); // Pass "Kitchen" to the Room constructor
    }

    //methods
    /**
     * This will create the trap scenrio for the user in the kitchen.
     * The player will input their choice and to defeat the trap.
     * param Scanner - user input
     */
    @Override
    public void trap(Scanner sc) {
        System.out.println("Room Description: This room is the kitchen. The kitchen has a fridge, table and chairs, a pantry and sink.");
        System.out.println("Situation: There is a trap set in the kitchen, where option is the best to get around it?");
        System.out.println("-------------------------");


        String userInput;
        boolean invalidChoice = false;

        do {
            System.out.println("You fell into a trap in the kitchen!");
            System.out.println("1. Use a frying pan to hit the trap.");
            System.out.println("2. Call for help.");
            System.out.println("3. Try to sneak out quietly.");
            System.out.print("Choose how to escape:");
            userInput = sc.nextLine();
            switch (userInput) {
            case "1":
                System.out.println("You hit the trap with the frying pan! It breaks open!");
                break;
            case "2":
                System.out.println("You call for help, but no one hears you.");
                break;
            case "3":
                System.out.println("You sneak out quietly and escape the trap!");
                break;
            default:
                System.out.println("Invalid choice! You remain trapped.");
                invalidChoice = true;
            }
        } while(invalidChoice);
    }

    /**
     * This will create the problem scenrio for the user in the kitchen.
     * The player will input their choice and to solve the problem.
     * param Scanner - user input
     */
    public void problem(Scanner sc){
        System.out.println("Room Description: This room is the kitchen. The kitchen has a fridge, table and chairs, a pantry and sink.");
        System.out.println("Situation: Gary has caused a major problem! He has clogged the sink and unplugged the fridge!");
        System.out.println("-------------------------");
        
        String userInput; 
        boolean invalidChoice = false;
        
        do {
           System.out.println("Enter the number that corresponds with how you want to handle the room's problems:");
           System.out.println("1 -> Unclog the sink first.");
           System.out.println("2 -> Plug in the fridge first.");
           System.out.println("3 -> Try to quickly plug in the fridge, then unclog the sink.");
           System.out.print("Please enter your option (1, 2, or 3): ");
           userInput = sc.nextLine();
           
           switch(userInput){
                case "1":
                    System.out.println("You have successfully unclogged the sink, but the food in the fridge has started to warm up.");
                    // Subtract time 
                    break;
                case "2":
                    System.out.println("You plugged in the fridge, saving the food, but the clogged sink has caused water to overflow.");
                    // Subtract time
                    break;
                case "3":
                    System.out.println("You quickly plugged in the fridge and then unclogged the sink.");
                    System.out.println("However, in your rush, you made a mess around the sink, costing you extra time to clean.");
                    // Subtract time
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3");
                    invalidChoice = true;
            }   
        
        } while(invalidChoice);
    }

    /**
     * This will create the problem scenrio for the user in the kitchen.
     * The player will input their choice and to figure out the puzzle.
     * param Scanner - user input
     */
    public void puzzle(Scanner sc){
        System.out.println("Room Description: This room is the kitchen. The kitchen has a fridge, table and chairs, a pantry and sink.");
        System.out.println("Situation: The puzzle will give you extra time! Determine the order to find the clue based on the riddle.");
        System.out.println("First: Go to the guardian of meals, then to the storage of preserved secrets, then where remenants and water meet.");
        System.out.println("-------------------------");
        
        String userInput; 
        boolean invalidChoice = false;
        
        do {
           System.out.println("Enter the number that corresponds with how you want to enter the room");
           System.out.println("1 -> Sink, Fridge, Table");
           System.out.println("2 -> Pantry Sink, Fridge");
           System.out.println("3 -> Fridge, Pantry, Sink");
           System.out.print("Please enter your option: ");
           userInput = sc.nextLine();
           
           switch(userInput){
            case "1":
                System.out.println("Incorrect order, puzzle not solved.");
                // Subtract time
                break;
            case "2":
                System.out.println("Puzzle not solved! No bonus!");
                // subtract time 
                break;
            case "3":
                System.out.println("Correct order! Puzzle Solved");
                // no punishment
                break;
            default:
                System.out.println("Invalid choice. Please enter 1, 2, or 3");
                invalidChoice = true;
            }   
        } while(invalidChoice);
    }

    /**
     * This method creates a sense of "fun" for the user and intensity.
     * The method prints a string of Gary trashtalking the user.
     * !Undecided on what it will say!
     */
    @Override
    public void taunt(Scanner sc) {
        // Just a placeholder for taunt
        System.out.println("Gary taunts you from another room!");
    }

    // Not implemented yet
    @Override
    public void catchGary(Scanner sc){
        System.out.println("next iteration");    
    }
}    
