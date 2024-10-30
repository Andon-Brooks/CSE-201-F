
public abstract class Room {
    private string roomName;

    public boolean wasGary;

    Room(String name) {
        this.roomName = name;
    }

    public void situation() {
        Scanner scan = new Scanner(System.in);

        // if gary.currentRoom = true it is automatically catchGary
        // if wasGary = true then randomly pick a sistuion to do
        // otherwise print a message that says that gary isnt there and nothing is wrong
    }

    private abstract void trap(Scanner sc);

    private abstract void puzzle(Scanner sc);

    private abstract void problem(Scanner sc);

    private abstract void taunt(Scanner sc);

    private abstract void catchGary(Scanner sc);
}