import java.util.Scanner;

public class Living extends Room {

    Living(String roomName, boolean wasGary) {
        super(roomName, wasGary);
    }

    @Override 
    public void trap(Scanner sc) {
        System.out.println("Room description: The living room, it has a coffee table, TV, and 3 houseplants in it."); 
        System.out.println("Situation: Trap."); 
        System.out.println("--------------------");
        System.out.println("Enter the number that corresponds with how you want to enter the room:");
        System.out.println("1 <- Option 1");
        System.out.println("2 <- Option 2");
        System.out.println("3 <- Option 3");
        System.out.println("4 <- Option 4");
        System.out.print("Please enter your option: ");
        String user_input;
        boolean unvalid;
        unvalid = true;

        do {
            user_input = sc.nextLine();
            switch (user_input) {
                case "1":
                    System.out.println("Bad");
                    unvalid = !unvalid;
                    break;
                case "2":
                    System.out.println("Also bad");
                    unvalid = !unvalid;
                    break;
                case "3":
                    System.out.println("Super bad");
                    unvalid = !unvalid;
                    break;
                case "4":
                    System.out.println("Correct");
                    unvalid = !unvalid;
                    break;
                default:
                    unvalid = true;
            }
        } while (unvalid);
    }

    @Override
    public void puzzle(Scanner sc) {
        System.out.println("Situation: Puzzle."); 
        System.out.println("Enter the number that corresponds with how you want to solve the puzzle:");
        System.out.println("1 <- Option 1");
        System.out.println("2 <- Option 2");
        System.out.println("3 <- Option 3");
        System.out.println("4 <- Option 4");
        System.out.print("Please enter your option: ");
        String user_input;
        boolean unvalid;
        unvalid = true;

        do {
            user_input = sc.nextLine();
            switch (user_input) {
                case "1":
                    System.out.println("Bad");
                    unvalid = !unvalid;
                    break;
                case "2":
                    System.out.println("Also bad");
                    unvalid = !unvalid;
                    break;
                case "3":
                    System.out.println("Super bad");
                    unvalid = !unvalid;
                    break;
                case "4":
                    System.out.println("Correct");
                    unvalid = !unvalid;
                    break;
                default:
                    unvalid = true;
            }
        } while (unvalid);
    }

    @Override
    public void problem(Scanner sc) {
        System.out.println("Situation: Puzzle."); 
        System.out.println("Enter the number that corresponds with how you want to solve the puzzle:");
        System.out.println("1 <- Option 1");
        System.out.println("2 <- Option 2");
        System.out.println("3 <- Option 3");
        System.out.println("4 <- Option 4");
        System.out.print("Please enter your option: ");
        String user_input;
        boolean unvalid;
        unvalid = true;

        do {
            user_input = sc.nextLine();
            switch (user_input) {
                case "1":
                    System.out.println("Bad");
                    unvalid = !unvalid;
                    break;
                case "2":
                    System.out.println("Also bad");
                    unvalid = !unvalid;
                    break;
                case "3":
                    System.out.println("Super bad");
                    unvalid = !unvalid;
                    break;
                case "4":
                    System.out.println("Correct");
                    unvalid = !unvalid;
                    break;
                default:
                    unvalid = true;
            }
        } while (unvalid);
    }

    @Override
    public void taunt() {
        System.out.println("Gary taunts you from another room!");
    }

    @Override
    public void catchGary() {
        //TODO: Next Iteration
    }
}