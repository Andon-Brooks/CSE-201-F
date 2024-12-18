/**
 * Class: GameUI
 * 
 * Author: Group F CSE 201
 * 
 * This class handles the UI of the game and contains the main game loop
 */

import java.util.Scanner;

/**
 * This class handles the UI of the game and contains the main game loop
 */
public class GameUI {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Game.startGame(scan);
        String choice;

        do {
            System.out.println("m -> menu");
            System.out.println("r -> move room");
            System.out.print("\nWhat would you like to do: ");
            choice = scan.nextLine().trim().toLowerCase();
            System.out.println();

            if (choice.equals("m")) {
                Game.mainMenu(scan);
            } else if (choice.equals("r")) {
                Game.move(scan);
            } else {
                System.out.println("-------------------------------------------");
                System.out.println("Invalid input, try again!");
                System.out.println("-------------------------------------------\n");
            }
        } while (Game.gameOver != true);
        Game.theEnd();
        scan.close();
    }
}
