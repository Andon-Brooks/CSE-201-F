import java.util.ArrayList;
import java.util.Scanner;

public static class game {
    private string name;

    private roomList = new ArrayList<Room>();

    private gary = new Gary("Mouse");

    public static boolean gameOver = false;

    /**
     * Creates Objects needed to start the Game
     */
    public void startGame() {
        Room firstRoom = new LivingRoom("LivingRoom");
        roomList.add(firstRoom);
        // roomList.add(new LivingRoom("LivingRoom"));
        roomList.add(new Kitchen("Kitchen"));
        roomList.add(new Bedroom("Bedroom"));
        // roomList.add(new Bathroom("Bathroom"));
        // roomList.add(new DinningRoom)
        // roomList.add(new Office("Office"));
        // roomList.add(new LaundryRoom("LaundryRoom"))

        GameUI.currentRoom = firstRoom;
        System.out.Println("Game Starting message");
    }
    
    /**
     * Gives the option to Continue, restat, quit, or get help
     */
    public void mainMenu(Scanner sc) {
        System.out.Println("c -> Continue");
        System.out.Println("r -> Restart");
        System.out.Println("q -> Quit");
        System.out.Println("What would you like to do? : ");

        String choice;
        do {
            choice = sc.nextLine();
            boolean unValid = false;
            switch (choice) {
            case "c":
                System.out.Println("continue message");
                break;
            case "r":
                System.out.Println("Restart Message");
                break;
            case "q":
                System.out.Println("Quit message");
                // Gameover = true
                break;
            default:
                System.out.Println("Invalid input, try again ");
                unValid = true;
            }
        } while (!unValid);
        
    }

    /**
     * 
     */
    public void helpMenu() {

    }

    /**
     * Prints a String containing all room names
     */
    public void printRooms() {
        String result = "";
        for (Room r : roomList) {
            result += r.roomName + " ";
        }
        System.out.Println(result);
    }

    /**
     * Moves player to a specfic room
     */
    public Room move(Scanner sc) {
            System.out.Println("Enter 'Back' to go back")
            System.out.Println("Avalible rooms to move to: ");
            printRooms();
        do {
            System.out.Print("Where would you like to go? : ")
            String choice = sc.nextLine();
            if (!choice.equals("Back")) {
                return GameUI.currentRoom;
            }

            for (Room r : roomList) {
                if (r.roomName.equals(choice)) {
                    return r;
                }
            }
            System.out.Println("Invalid choice, try again! ");
        } while(!choice.equals("Back"));
    }

    /**
     * Prints a notification contianing...
     */
    public void notification() {
        System.out.Println("This is a notification full of information")
    }

    /**
     * Prints game over message stating how and why the game ended
     */
    public void gameOverMessage() {
        System.out.Println("Game Over :(");
    }
}
