import java.util.Scanner;

public class Living extends Room {
    Kitchen(String roomName) {
        // super(roomName);
    }

    @Override 
    trap(Scanner sc) {
        System.out.println("Description of trap as done by Gary."); 
        System.out.println("Your cat brain thinks up 4 ways to deal with this:");
        System.out.println("Option 1");
        System.out.println("Option 2");
        System.out.println("Option 3");
        System.out.println("Option 4");
        System.out.print("What do?: ");
        String user_input = sc.nextLine();

        switch (user_input) {
            case "1":
                System.out.println("Bad");
                break;
            case "2":
                System.out.println("Also bad");
                break;
            case "3":
                System.out.println("Super bad");
                break;
            case "4":
                System.out.println("Correct");
                break;
            default:
                System.out.println("You do nothing as [trap does thing].");
        }
    }

    @Override
    puzzle(Scanner sc) {

    }

    @Override
    problem(Scanner sc) {

    }

    @Override
    taunt() {
        return "I've seen turtles move faster than you!";
    }

    @Override
    catchGary() {
        
    }
}