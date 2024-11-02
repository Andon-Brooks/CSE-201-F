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
     * Constructor to build the room.
     */
    public Bedroom(){
        super("Bedroom");
    }

    //methods
    /**
     * This will create the problem scenrio for the user in the bedroom.
     * The player will input their choice and to solve the problem.
     * param Scanner - user input
     */
    @Override
    public void problem(Scanner sc){
        System.out.println("Room Description: This room is the bedroom. The bedroom is quiet and Gary has been known to spend most of his time hanging out in here. It contains a bed, tv and a dresser.");
        System.out.println("Situation: Gary has been up to no good. The TV is hanging off the edge of the dresser and Gary has opened the window and birds are sitting on the seal.");
        System.out.println("-------------------------");
        
        String userInput; 
        boolean invalidChoice = false;
        
        do {
           System.out.println("Enter the number that corresponds with how you want to enter the room");
           System.out.println("1 -> Fix the TV so it is will not fall");
           System.out.println("2 -> Close the window to prevent birds from coming in the bedroom");
           System.out.println("3 -> Try to distract the birds and fix the TV, then close the window");
           System.out.println("Please enter your option: ");
           userInput = sc.nextLine();
           
           switch(userInput){
            case "1":
                System.out.println("You have stopped the TV from falling, although the birds have entered the room.");
                // Subtract time
                break;
            case "2":
                System.out.println("You have sucessfully gotten the birds out and close the window, however the TV has shattered");
                // subtract time 
                break;
            case "3":
                System.out.println("You tried to throw a shoe at the birds. The birds were scared off, doing so you made it to the TV, then closed the window.");
                System.out.println("However, you broke the lamp with the shoe, now you have lost time in cleaning up the mess you made.");
                //Subtract time
                break;
            default:
                System.out.println("Invalid choice. Please enter 1, 2, or 3");
                invalidChoice = true;
            }   
        
        } while(invalidChoice);
    }

    
    /**
     * This will create the trap scenrio for the user in the bedroom.
     * The player will input their choice and to defeat the trap.
     * param Scanner - user input
     */
    @Override
    public void trap(Scanner sc){

        System.out.println("Room Description: This room is the bedroom. The bedroom is quiet and Gary has been known to spend most of his time hanging out in here. It contains a bed and a dresser.");
        System.out.println("Situation: Gary has placed a trap to deploy when you walk in, how do you want to enter the room?");
        System.out.println("-------------------------");
        String userInput; 
        boolean invalidChoice = false;
        
        do {
           System.out.println("Enter the number that corresponds with how you want to enter the room");
           System.out.println("1 -> Crawl into the room to avoid any swinging objects");
           System.out.println("2 -> Swing into the room to avoid a trap that could be placed on the ground");
           System.out.println("3 -> Walk in normally assuming trap is elsewhere in the room");
           System.out.println("Please enter your option: ");
           userInput = sc.nextLine();
           
           switch(userInput){
            case "1":
                System.out.println("You have been hit by a swinging ball attached to the top of the door.");
                // Subtract time
                break;
            case "2":
                System.out.println("You have successfully avoided the marbles in front of the door by swinging into the room");
                // no punishment
                break;
            case "3":
                System.out.println("You have been hit by a swinging ball attached to the top of the door.");
                //Subtract time
                break;
            default:
                System.out.println("Invalid choice. Please enter 1, 2, or 3");
                invalidChoice = true;
            }   
        
        } while(invalidChoice);
    }

    /**
     * This will create the problem scenrio for the user in the bedroom.
     * The player will input their choice and to figure out the puzzle.
     * param Scanner - user input
     */
    @Override
    public void puzzle(Scanner sc){
        System.out.println("Room Description: This room is the bedroom. The bedroom is quiet and Gary has been known to spend most of his time hanging out in here. It contains a bed and a dresser.");
        System.out.println("Situation: Find the hidden mess, what a distress, the mess would be where you find a dress?");
        System.out.println("-------------------------");
        
        String userInput; 
        boolean invalidChoice = false;
        
        do {
           System.out.println("Enter the number that corresponds with how you want to enter the room");
           System.out.println("1 -> Container under the bed");
           System.out.println("2 -> Hanging on the door");
           System.out.println("3 -> In the dresser");
           System.out.println("Please enter your option: ");
           userInput = sc.nextLine();
           
           switch(userInput){
            case "1":
                System.out.println("You did not find the mess");
                // Subtract time
                break;
            case "2":
                System.out.println("You did not find the mess.");
                // no punishment
                break;
            case "3":
                System.out.println("Correct, the dresser is where the mess is. You have saved time.");
                //Subtract time
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
    public void taunt(){
        System.out.println("Next iteration");
    }

    // Not implemented yet
    @Override
    public void catchGary(Scanner sc){
        System.out.println("next iteration");    
    }
}
