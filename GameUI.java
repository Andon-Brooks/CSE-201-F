import java.util.Scanner;

public static class gameUI {

    public static Room currentRoom;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Game.startGame();
        String choice;
        do () {
            System.out.Println("m -> menu");
            System.out.Println("r -> move room");
            System.out.Println("What would you like to do: ")
            choice = scan.nextLine();
            if (choice.equals"m") {
                Game.mainMenu(scan);
            } else if (choice.equals("r")) {
                Game.gary.move();
                currentRoom = Game.move(scan);
                currentRoom.situation(sc);
            } else {
                System.out.Println("Invalid input, try again");
            }
        } while (Game.gameOver != true);
        Game.gameOverMessage();
        scan.close();
    }
}
