
public static class game {
    private string name;

    public static boolean gameOver = false;

    /**
     * Creates Objects needed to start the Game
     */
    public void startGame() {
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

        char choice = sc.next();
        switch (choice) {
            case 'c':
                System.out.Println("continue message");
                break;
            case 'r':
                System.out.Println("Restart Message");
                break;
            case 'q'
                System.out.Println("Quit message");
                // Gameover = true
                break;
            default:
                System.out.Println("Invalid input, tery ")

        }
    }

    /**
     * 
     */
    public void helpMenu() {

    }

    /**
     * 
     */
    public void move() {

    }

    /**
     * 
     */
    public void notification() {

    }

    /**
     * 
     */
    public void gameOverMessage() {

    }

    /**
     * 
     */
    public boolean getGameover() {

    }
}
