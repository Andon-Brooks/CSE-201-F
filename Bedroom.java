/**
 * Class: Bedroom 
 * 
 * @author: Group F CSE 201
 * 
 * This is a child class of Room. This class represents the bedroom in our game,
 * where players encounter unique scenarios and interact based on their choices.
 * The room offers various challenges such as traps, puzzles, and problems,
 * each affecting the game state differently.
 */
import java.util.Scanner;

public class Bedroom extends Room {
  
    /**
     * Constructor to build the room and pass the room name to the parent class.
     */
    public Bedroom(){
        super("Bedroom");
    }

    /**
     * Creates a problem scenario for the user in the Bedroom.
     * The player selects an option to address the issue of an unstable TV and an open window.
     * 
     * @param sc Scanner object for user input.
     */
    @Override
    public void problem(Scanner sc){
        System.out.println("\nRoom Description: This room is the bedroom. The bedroom is quiet and Gary has been known to spend most of his time hanging out in here. It contains a bed, tv and a dresser.");
        System.out.println("Situation: Gary has been up to no good. The TV is hanging off the edge of the dresser and Gary has opened the window and birds are sitting on the seal.");
        System.out.println("-------------------------");
        
        String userInput; 
        boolean invalidChoice = false;

        Game.problemsEncountered++;    
        
        do {
            invalidChoice = false;

           System.out.println("Enter the number that corresponds with how you want to enter the room\n");
           System.out.println("1 -> Fix the TV so it is will not fall");
           System.out.println("2 -> Close the window to prevent birds from coming in the bedroom");
           System.out.println("3 -> Try to distract the birds and fix the TV, then close the window");
           
           System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");   

           System.out.print("\nPlease enter your option: ");
           userInput = sc.nextLine().trim();
           
           switch(userInput){
            case "1":
                System.out.println("\nYou have stopped the TV from falling, although the birds have entered the room.\n---\n");
                Game.clock.deductTime(5);   
                break;
            case "2":
                System.out.println("\nYou have sucessfully gotten the birds out and close the window, however the TV has shattered.\n---\n");
                Game.clock.deductTime(10);  
                break;
            case "3":
                System.out.println("\nYou tried to throw a shoe at the birds. The birds were scared off, doing so you made it to the TV, then closed the window.");
                System.out.println("However, you broke the lamp with the shoe, now you have lost time in cleaning up the mess you made.\n---\n");
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
        
        } while(invalidChoice);
    }
    
    /**
     * Creates a trap scenario for the user in the Bedroom.
     * The player selects an action to avoid a potential trap set by Gary.
     * 
     * @param sc Scanner object for user input.
     */
    @Override
    public void trap(Scanner sc){
        Game.trapsEncountered++;    

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
           
           System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");   

           System.out.print("\nPlease enter your option: ");
           userInput = sc.nextLine().trim();
           
           switch(userInput){
            case "1":
                System.out.println("\nYou have been hit by a swinging ball attached to the top of the door.\n---\n");
                Game.clock.deductTime(10);  
                Game.unsolvedTraps++;
                break;
            case "2":
                System.out.println("\nYou have successfully avoided the marbles in front of the door by swinging into the room.\n---\n");
                Game.trapsSolved++;     
                break;
            case "3":
                System.out.println("\nYou have been hit by a swinging ball attached to the top of the door.\n---\n");
                Game.clock.deductTime(10);  
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
        
        } while(invalidChoice);
    }

    /**
     * Creates a puzzle scenario for the user in the Bedroom.
     * The player will input their choice and to figure out the puzzle.
     *
     * @param sc Scanner object for user input.
     */
    @Override
    public void puzzle(Scanner sc){
        Game.puzzlesEncountered++;  
        
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

           System.out.println("4 -> Give up and forfeit this turn, but keep in mind it will be a 30 minutes penalty!");   

           System.out.print("\nPlease enter your option: ");
           userInput = sc.nextLine().trim();
           
           switch(userInput){
            case "1":
                System.out.println("\nYou did not find the mess.\n---\n");
                Game.clock.deductTime(5);   
                break;
            case "2":
                System.out.println("\nYou did not find the mess.\n---\n");
                Game.clock.deductTime(5);   
                break;
            case "3":
                System.out.println("\nCorrect, the dresser is where the mess is. You have saved time.\n---\n");
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
        
        } while(invalidChoice);
    }

    /**
     * Provides a taunt scenario for the user in the Bedroom.
     * The method prints a string of Gary trashtalking the user.
     *
     * @param sc Scanner object for user input.
     */
    @Override
    public void taunt(Scanner sc){
        System.out.println("\nA note was left on the bed saying, 'HAHAHAHAHA - Gary ;)'\n---\n");
    }

     /**
     * Catches Gary in the Bedroom and triggers the end game summary.
     * 
     * @param sc Scanner object for user input.
     */
    @Override
    public void catchGary(Scanner sc){
        System.out.println("\nGary is hiding in the bedroom! You caught him!\n---\n");
        Game.hasCaughtGary = true;
        Game.gameOver = true;
        Game.displayEndGameSummary();
    }
}
