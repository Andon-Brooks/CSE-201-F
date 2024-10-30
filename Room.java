public abstract class Room {
    private String roomName;
    private boolean wasGary;

    Room(String roomName) {
        this.roomName = roomName;
        this.wasGary = false; // Initially, Gary has not been in this room
    }

    public String getRoomName() {
        return roomName;
    }

    public boolean wasGary() {
        return wasGary;
    }

    public void setWasGary(boolean wasGary) {
        this.wasGary = wasGary;
    }

    public abstract void trap();
    
    public abstract void puzzle();
    
    public abstract void problem();
    
    public abstract void taunt();
    
    public abstract void catchGary();
}
