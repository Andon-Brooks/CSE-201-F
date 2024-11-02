import java.util.Scanner;

public class Living extends Room {
    public Living() {
        super("Living");
    }

    /*
     * @param Scanner sc 
     * This function describes a trap laid out by Gary in the living room. The scanner is used to
     * scan for user input and correlate it with a set of options below. Depending on the choice,
     * the player will either pick correctly or incorrectly, in which time is also deducted.
     */
    @Override 
    public void trap(Scanner sc) {
        System.out.println("Room description: The living room, where all of your owner's friends come n' go.");
        System.out.println("Gary doesn't come here too much, he doesn't want to get caught. It has a coffee table, TV, and 3 houseplants in it.");
        System.out.println("Situation: Gary made himself a trap that'll be set off as soon as you walk in."); 
        System.out.println("-------------------------");
        String user_input;

        do {
            System.out.println("Enter the number that corresponds with how you want to enter the room:");
            System.out.println("1 <- Jump into the room");
            System.out.println("2 <- Crawl into the room");
            System.out.println("3 <- Walk in assuming the trap is elsewhere");
            System.out.print("Please enter your option: ");
            user_input = sc.nextLine();
            boolean invalid = false;

            switch (user_input) {
                case "1":
                    System.out.println("You make it over the pile of mousetraps that are in front of the door. ");
                    invalid = !unvalid;
                    break;
                case "2":
                    System.out.println("You crawl in, and your tail gets caught in one of the mousetraps. ");
                    // Time deduction
                    invalid = !invalid;
                    break;
                case "3":
                    System.out.println("You waltz in and proceed to step into several mousetraps. ");
                    // Time deduction
                    invalid = !invalid;
                    break;
                default:
                System.out.println("Please input a valid response.");
                    invalid = true;
            }
        } while (invalid);
    }

    /*
     * @param Scanner sc 
     * This function describes a puzzle that Gary created. The scanner is used to
     * scan for user input and correlate it with a set of options below. Depending on the choice,
     * the player will either pick correctly or incorrectly, in which time is also deducted.
     */
    @Override
    public void puzzle(Scanner sc) {
        System.out.println("Room description: The living room, where all of your owner's friends come n' go.");
        System.out.println("Gary doesn't come here too much, he doesn't want to get caught. It has a coffee table, TV, and 3 houseplants in it.");
        System.out.println("Situation: You realize that the television's remote is gone, and Gary hid it somewhere."); 
        System.out.println("-------------------------");
        String user_input;

        do {
            System.out.println("Enter the number that corresponds with what objects you want to check:");
            System.out.println("1 <- Check in one of the houseplants");
            System.out.println("2 <- Check under the couch");
            System.out.println("3 <- Check behind the TV");
            System.out.print("Please enter your option: ");
            user_input = sc.nextLine();
            boolean invalid = false;

            switch (user_input) {
                case "1":
                    System.out.println("You dig into one of the houseplants and find nothing. There's dirt lying everywhere. ");
                    // Time deduction
                    invalid = !unvalid;
                    break;
                case "2":
                    System.out.println("You find the remote wedged into the couch and take it out! ");
                    invalid = !invalid;
                    break;
                case "3":
                    System.out.println("You check behind the TV and accidentally knock it over. ");
                    // Time deduction
                    invalid = !invalid;
                    break;
                default:
                System.out.println("Please input a valid response. ");
                    invalid = true;
            }
        } while (invalid);
    }

    /*
     * @param Scanner sc 
     * This function describes a problem in the room that Gary has caused. The scanner is used to
     * scan for user input and correlate it with a set of options below. Depending on the choice,
     * the player will either pick correctly or incorrectly, in which time is also deducted.
     */
    @Override
    public void problem(Scanner sc) {
        System.out.println("Room description: The living room, where all of your owner's friends come n' go.");
        System.out.println("Gary doesn't come here too much, he doesn't want to get caught. It has a coffee table, TV, and 3 houseplants in it.");
        System.out.println("Situation: As you come into the living room, you see several hot coffee cups on the verge of falling onto the carpet."); 
        System.out.println("-------------------------");
        String user_input;

        do {
            System.out.println("Enter the number that corresponds with how you want to solve this problem:");
            System.out.println("1 <- Dive and save the cups before they fall onto the ground");
            System.out.println("2 <- Shove the cups back onto the table");
            System.out.println("3 <- Drink all of the coffee as it falls out");
            System.out.print("Please enter your option: ");
            user_input = sc.nextLine();
            boolean invalid = false;

            switch (user_input) {
                case "1":
                    System.out.println("You fly right below the cups, but the heat of the cups burns you. Coffee flies everywhere!");
                    // Time deduction
                    invalid = !unvalid;
                    break;
                case "2":
                    System.out.println("You shove the coffee cups right as they're about to fall, but you shove it off the other side of the table.");
                    // Time deduction
                    invalid = !invalid;
                    break;
                case "3":
                    System.out.println("You yank all of the coffee cups and chug them. They taste good, too!");
                    invalid = !invalid;
                    break;
                default:
                System.out.println("Please input a valid response. ");
                    invalid = true;
            }
        } while (invalid);
    }

    /*
     * This function prints out a taunt to indicate that Gary is in another room.
     */
    @Override
    public void taunt() {
        System.out.println("Gary taunts you from another room!");
    }

    /*
     * This function is meant to run when Gary is about to be caught
     */
    @Override
    public void catchGary() {
        //TODO: Next Iteration
    }
}