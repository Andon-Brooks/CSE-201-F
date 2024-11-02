import java.util.Scanner;
/**
 * This class handles the UI of the game and contains the main game loop
 */
public class GameUI {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Game.startGame();
        String choice;
        
        do {
            System.out.println("m -> menu");
            System.out.println("r -> move room");
            System.out.print("What would you like to do: ");
            choice = scan.nextLine();
            
            if (choice.equals("m")) {
                Game.mainMenu(scan);
            } else if (choice.equals("r")) {
                Game.move(scan);
            } else {
                System.out.println("Invalid input, try again");
            }
        } while (Game.gameOver != true);
        Game.gameOverMessage();
        scan.close();
    }
}
