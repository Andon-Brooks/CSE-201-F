/**
 * Class: Bedroom 
 * 
 * Author: Group F CSE 201
 * 
 * This is child class of Room. This class is to implement one of the rooms 
 * in our game for the user to interact with. The room will provide scenarios and effects based
 * on user input to move around and solve various scenario in the bedroom.
 */
import java.util.Scanner;

public class Bedroom extends Room {
    /**
     * Constructor to build the Bedroom.
     */
    public Bedroom(){
        super("Bedroom");
    }

    /*
    * Method that presents a problem to the user relevant to the Bedroom
    * 
    * @param sc Scanner object user fot I/O
    */
    @Override
    public void problem(Scanner sc){
        System.out.println("\nRoom Description: This room is the bedroom. The bedroom is quiet and Gary has been known to spend most of his time hanging out in here. It contains a bed, tv and a dresser.");
        System.out.println("Situation: Gary has been up to no good. The TV is hanging off the edge of the dresser and Gary has opened the window and birds are sitting on the seal.");
        System.out.println("-------------------------");
        
        String userInput; 
        boolean invalidChoice = false;

        Game.problemsEncountered++;    // Counter for end of game summary
        
        do {
            invalidChoice = false;

           System.out.println("Enter the number that corresponds with how you want to enter the room\n");
           System.out.println("1 -> Fix the TV so it is will not fall");
           System.out.println("2 -> Close the window to prevent birds from coming in the bedroom");
           System.out.println("3 -> Try to distract the birds and fix the TV, then close the window");
           
           System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");   // Forfeit option

           System.out.print("\nPlease enter your option: ");
           userInput = sc.nextLine().trim();
           
           switch(userInput){
            case "1":
                System.out.println("\nYou have stopped the TV from falling, although the birds have entered the room.\n---\n");
                Game.clock.deductTime(5);   // Time deduction
                break;
            case "2":
                System.out.println("\nYou have sucessfully gotten the birds out and close the window, however the TV has shattered.\n---\n");
                Game.clock.deductTime(10);  // Time deduction
                break;
            case "3":
                System.out.println("\nYou tried to throw a shoe at the birds. The birds were scared off, doing so you made it to the TV, then closed the window.");
                System.out.println("However, you broke the lamp with the shoe, now you have lost time in cleaning up the mess you made.\n---\n");
                Game.clock.deductTime(15);  // Time deduction
                break;
            case "4":
                System.out.println("\nYou chose to give up and forfeit this turn.\n---\n");
                Game.clock.deductTime(30);  // Time deduction
                Game.forfeits++;    // Forfeited turn counter for end of game summary
            break;
            default:
                System.out.println("\nInvalid choice. Please enter 1, 2, 3, or 4!");
                System.out.println("-------------------------------------------\n");
                invalidChoice = true;
            }   
        
        } while(invalidChoice);
    }
    
   /*
    * Method that presents a trap to the user relevant to the Bedroom
    * 
    * @param sc Scanner object user fot I/O
    */
    @Override
    public void trap(Scanner sc){
        Game.trapsEncountered++;    // Traps encountered counter for end of game summary

        System.out.println("\nRoom Description: This room is the bedroom. The bedroom is quiet and Gary has been known to spend most of his time hanging out in here. It contains a bed and a dresser.");
        System.out.println("Situation: Gary has placed a trap to deploy when you walk in, how do you want to enter the room?");
        System.out.println("-------------------------");
        String userInput; 
        boolean invalidChoice = false;
        
        do {
            invalidChoice = false;

           System.out.println("Enter the number that corresponds with how you want to enter the room:\n");
           System.out.println("1 -> Crawl into the room to avoid any swinging objects");
           System.out.println("2 -> Swing into the room to avoid a trap that could be placed on the ground");
           System.out.println("3 -> Walk in normally assuming trap is elsewhere in the room");
           
           System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");   // Forfeit option

           System.out.print("\nPlease enter your option: ");
           userInput = sc.nextLine().trim();
           
           switch(userInput){
            case "1":
                System.out.println("\nYou have been hit by a swinging ball attached to the top of the door.\n---\n");
                Game.clock.deductTime(10);  // Time deduction
                Game.unsolvedTraps++;
                break;
            case "2":
                System.out.println("\nYou have successfully avoided the marbles in front of the door by swinging into the room.\n---\n");
                // no punishment
                Game.trapsSolved++;     // Traps solved counter for end of game summary
                break;
            case "3":
                System.out.println("\nYou have been hit by a swinging ball attached to the top of the door.\n---\n");
                Game.clock.deductTime(10);  // Time deduction
                Game.unsolvedTraps++;
                break;
            case "4":
                System.out.println("\nYou chose to give up and forfeit this turn.\n---\n");
                Game.clock.deductTime(30);  // Time deduction
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
        
        } while(invalidChoice);
    }

    /*
    * Method that presents a puzzle to the user relevant to the Bedroom
    * 
    * @param sc Scanner object user fot I/O
    */
    @Override
    public void puzzle(Scanner sc){
        Game.puzzlesEncountered++;  // Puzzles encountered counter for end of game summary
        
        System.out.println("\nRoom Description: This room is the bedroom. The bedroom is quiet and Gary has been known to spend most of his time hanging out in here. It contains a bed and a dresser.");
        System.out.println("Situation: Find the hidden mess, what a distress, the mess would be where you find a dress?");
        System.out.println("-------------------------");
        
        String userInput; 
        boolean invalidChoice = false;
        
        do {
            invalidChoice = false;

           System.out.println("Enter the number that corresponds with how you want to enter the room:\n");
           System.out.println("1 -> Container under the bed");
           System.out.println("2 -> Hanging on the door");
           System.out.println("3 -> In the dresser");

           System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");   // Forfeit option

           System.out.print("\nPlease enter your option: ");
           userInput = sc.nextLine().trim();
           
           switch(userInput){
            case "1":
                System.out.println("\nYou did not find the mess.\n---\n");
                Game.clock.deductTime(5);   // Time deduction
                break;
            case "2":
                System.out.println("\nYou did not find the mess.\n---\n");
                // no punishment --> Not sure why there would be no punishment here??? He didn't find the mess
                Game.clock.deductTime(5);   // Time deduction
                break;
            case "3":
                System.out.println("\nCorrect, the dresser is where the mess is. You have saved time.\n---\n");
                Game.clock.addTime(5);  // Adding time for solving correctly... although I feel it doesn't entirely make sense to add time for this...
                                                     // ... what if we had some sort of different system for when they do things correctly like this? I don't know
                Game.puzzlesSolved++;   // Puzzles solved counter for end of game summary
                break;
            case "4":
                System.out.println("\nYou chose to give up and forfeit this turn.\n---\n");
                Game.clock.deductTime(30);  // Time deduction
                Game.forfeits++;    // Forfeit counter for end of game summary
            break;
            default:
                System.out.println("\nInvalid choice. Please enter 1, 2, 3, or 4!");
                System.out.println("-------------------------------------------\n");
                invalidChoice = true;
            }   
        
        } while(invalidChoice);
    }

    /*
    * Method that presents a taunt to the user relevant to the Bedroom
    * 
    * @param sc Scanner object user fot I/O
    */
    @Override
    public void taunt(Scanner sc){
        System.out.println("\nA note was left on the bed saying, 'HAHAHAHAHA - Gary ;)'\n---\n");
    }

    /*
    * Method that presents a catch gary situation to the user relevant to the Bedroom
    * 
    * @param sc Scanner object user fot I/O
    */
    @Override
    public void catchGary(Scanner sc){
        System.out.println("\nGary is hiding in the bedroom! You caught him!\n---\n");
        Game.hasCaughtGary = true;
        Game.gameOver = true;
        Game.displayEndGameSummary();
    }
}
