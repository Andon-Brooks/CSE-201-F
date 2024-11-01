import java.util.Scanner;

public class Kitchen extends Room {

    public Kitchen() {
        super("Kitchen"); // Pass "Kitchen" to the Room constructor
    }

    @Override
    public void trap(Scanner sc) {
        System.out.println("You fell into a trap in the kitchen!");
        System.out.println("Choose how to escape:");
        System.out.println("1. Use a frying pan to hit the trap.");
        System.out.println("2. Call for help.");
        System.out.println("3. Try to sneak out quietly.");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.println("You hit the trap with the frying pan! It breaks open!");
                break;
            case 2:
                System.out.println("You call for help, but no one hears you.");
                break;
            case 3:
                System.out.println("You sneak out quietly and escape the trap!");
                break;
            default:
                System.out.println("Invalid choice! You remain trapped.");
        }
    }

    @Override
    public void taunt(Scanner sc) {
        // Just a placeholder for taunt
        System.out.println("Gary taunts you from another room!");
    }
