
public abstract class Room {
    private string roomName;

    private boolean wasGary;

    Room(String name) {
        this.roomName = name;
    }

    public abstract void trap();

    public abstract void puzzle();

    public abstract void problem();

    public abstract void taunt();

    public abstract void catchGary();
}