import java.util.Scanner;

public class Bedroom extends Room {

    public Bedroom(){
        this.wasGary = false;
    
    }

    @Override
    problem(Scanner sc){
        System.out.println("Room Description: This room is the bedroom. The bedroom is quiet and Gary has been known to spend most of his time hanging out in here. It contains a bed, tv and a dresser.");
        System.out.println("Situation: Gary has been up to no good. The TV is hanging off the edge of the dresser and Gary has opened the window and birds are sitting on the seal.");
        System.out.println("-------------------------");
        
        
        String userInput; 
        
        do {
           userInput = sc.nextLine();
           boolean invalidChoice = false;
           System.out.println("Enter the number that corresponds with how you want to enter the room");
           System.out.println("1 -> Fix the TV so it is will not fall");
           System.out.println("2 -> Close the window to prevent birds from coming in the bedroom");
           System.out.println("3 -> Try to distract the birds and fix the TV, then close the window");
           System.out.println("Please enter your option: ");
           
           switch(userInput){
            case "1":
                System.out.println("You have stopped the TV from falling, although the birds have entered the room.");
                // Subtract time
                break;
            case 2:
                System.out.println("You have sucessfully gotten the birds out and close the window, however the TV has shattered");
                // subtract time 
                break;
            case 3:
                System.out.println("You tried to throw a shoe at the birds. The birds were scared off, doing so you made it to the TV, then closed the window.");
                System.out.println("However, you broke the lamp with the shoe, now you have lost time in cleaning up the mess you made.")
                //Subtract time
                break;
            default:
                System.out.println("Invalid choice. Please enter 1, 2, or 3");
                invalidChoice = true;
            }   
        
        } while(invalidChoice);
    }

    @Override
    trap(Scanner sc){

        System.out.println("Room Description: This room is the bedroom. The bedroom is quiet and Gary has been known to spend most of his time hanging out in here. It contains a bed and a dresser.");
        System.out.println("Situation: Gary has placed a trap to deploy when you walk in, how do you want to enter the room?");
        System.out.println("-------------------------");
        String userInput; 
        
        do {
           userInput = sc.nextLine();
           boolean invalidChoice = false;
           System.out.println("Enter the number that corresponds with how you want to enter the room");
           System.out.println("1 -> Crawl into the room to avoid any swinging objects");
           System.out.println("2 -> Swing into the room to avoid a trap that could be placed on the ground");
           System.out.println("3 -> Walk in normally assuming trap is elsewhere in the room");
           System.out.println("Please enter your option: ");
           
           switch(userInput){
            case "1":
                System.out.println("You have been hit by a swinging ball attached to the top of the door.");
                // Subtract time
                break;
            case 2:
                System.out.println("You have successfully avoided the marbles in front of the door by swinging into the room");
                // no punishment
                break;
            case 3:
                System.out.println("You have been hit by a swinging ball attached to the top of the door.");
                //Subtract time
                break;
            default:
                System.out.println("Invalid choice. Please enter 1, 2, or 3");
                invalidChoice = true;
            }   
        
        } while(invalidChoice);
    }

    @Override
    puzzle(Scanner sc){
        System.out.println("Room Description: This room is the bedroom. The bedroom is quiet and Gary has been known to spend most of his time hanging out in here. It contains a bed and a dresser.");
        System.out.println("Situation: Gary has placed a trap to deploy when you walk in, how do you want to enter the room?");
        System.out.println("-------------------------");
        
        String userInput; 
        
        do {
           userInput = sc.nextLine();
           boolean invalidChoice = false;
           System.out.println("Enter the number that corresponds with how you want to enter the room");
           System.out.println("1 -> Crawl into the room to avoid any swinging objects");
           System.out.println("2 -> Swing into the room to avoid a trap that could be placed on the ground");
           System.out.println("3 -> Walk in normally assuming trap is elsewhere in the room");
           System.out.println("Please enter your option: ");
           
           switch(userInput){
            case "1":
                System.out.println("You have been hit by a swinging ball attached to the top of the door.");
                // Subtract time
                break;
            case 2:
                System.out.println("You have successfully avoided the marbles in front of the door by swinging into the room");
                // no punishment
                break;
            case 3:
                System.out.println("You have been hit by a swinging ball attached to the top of the door.");
                //Subtract time
                break;
            default:
                System.out.println("Invalid choice. Please enter 1, 2, or 3");
                invalidChoice = true;
            }   
        
        } while(invalidChoice);
    }

    @Override
    problem(Scanner sc){
        System.out.println("Room Description: This room is the bedroom. The bedroom is quiet and Gary has been known to spend most of his time hanging out in here. It contains a bed and a dresser.");
        System.out.println("Situation: Gary has placed a trap to deploy when you walk in, how do you want to enter the room?");
        System.out.println("-------------------------");
        
        String userInput; 
        
        do {
           userInput = sc.nextLine();
           boolean invalidChoice = false;
           System.out.println("Enter the number that corresponds with how you want to enter the room");
           System.out.println("1 -> Crawl into the room to avoid any swinging objects");
           System.out.println("2 -> Swing into the room to avoid a trap that could be placed on the ground");
           System.out.println("3 -> Walk in normally assuming trap is elsewhere in the room");
           System.out.println("Please enter your option: ");
           
           switch(userInput){
            case "1":
                System.out.println("You have been hit by a swinging ball attached to the top of the door.");
                // Subtract time
                break;
            case 2:
                System.out.println("You have successfully avoided the marbles in front of the door by swinging into the room");
                // no punishment
                break;
            case 3:
                System.out.println("You have been hit by a swinging ball attached to the top of the door.");
                //Subtract time
                break;
            default:
                System.out.println("Invalid choice. Please enter 1, 2, or 3");
                invalidChoice = true;
            }   
        
        } while(invalidChoice);
        
    }

    @Override
    taunt(Scanner sc){
        System.out.println("Room Description: This room is the bedroom. The bedroom is quiet and Gary has been known to spend most of his time hanging out in here. It contains a bed and a dresser.");
        System.out.println("Situation: Gary has placed a trap to deploy when you walk in, how do you want to enter the room?");
        System.out.println("-------------------------");
        String userInput; 
        
        do {
           userInput = sc.nextLine();
           boolean invalidChoice = false;
           System.out.println("Enter the number that corresponds with how you want to enter the room");
           System.out.println("1 -> Crawl into the room to avoid any swinging objects");
           System.out.println("2 -> Swing into the room to avoid a trap that could be placed on the ground");
           System.out.println("3 -> Walk in normally assuming trap is elsewhere in the room");
           System.out.println("Please enter your option: ");
           
           switch(userInput){
            case "1":
                System.out.println("You have been hit by a swinging ball attached to the top of the door.");
                // Subtract time
                break;
            case 2:
                System.out.println("You have successfully avoided the marbles in front of the door by swinging into the room");
                // no punishment
                break;
            case 3:
                System.out.println("You have been hit by a swinging ball attached to the top of the door.");
                //Subtract time
                break;
            default:
                System.out.println("Invalid choice. Please enter 1, 2, or 3");
                invalidChoice = true;
            }   
        
        } while(invalidChoice);

    }

    @Override
    catchGary(Scanner sc){
        System.out.println("next iteration");    
    }

}
