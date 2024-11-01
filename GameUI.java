import java.util.Scanner;

public class gameUI {

    public Room currentRoom;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Game.startGame();
        do () {
            System.out.Println("m -> menu");
            System.out.Println("r -> move room");
            
        } while (Game.gameOver != true);
        Game.gameOverMessage();
        scan.close();
    }
}
