
import java.util.Scanner;

public class Bedroom extends Room {

    public Bedroom(){
        this.wasGary = false;
    
    }

    @Override
    problem(Scanner sc){
        
    }

    @Override
    trap(Scanner sc){
        System.out.println("Situation: Gary has placed a trap to deploy when you walk in, how do you want to enter the room?");
        System.out.println("Enter the number that corresponds with how you want to enter the room");
        System.out.println("1 -> Crawl into the room to avoid any swinging objects");
        System.out.println("2 -> Swing into the room to avoid a trap that could be placed on the ground");
        System.out.println("3 -> Walk in normally assuming trap is elsewhere in the room");
        System.out.println("Please enter your option: ")''
        String userInput = sc.nextLine();

        if(userInput != 1 || )
        

        switch(userInput){
            case "1":
                System.out.println("");
                break;
            case 2:
                System.out.println("");
                break;
            case 3:
                System.out.println("");
                break;
            default:
                System.out.println("Invalid choice. Please");
                break;
            }   
        
        }while(userInput)
    }


    }

    @Override
    puzzle(Scanner sc){

    }

    @Override
    problem(Scanner sc){

    }

    @Override
    taunt(Scanner sc){

    }

    @Override
    catchGary(Scanner sc){

    }

}