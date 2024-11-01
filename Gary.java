import java.lang.Math;

public class Gary {
    private Room currentRoom;

    private String name;

    Gary(String name) {
        this.name = name;
        this.move();
    }

    public Room move() {
        Random rand = new Random();
        int randomNumber = rand.nextInt(roomList.size());
        currentRoom = roomList.get(randomNumber);
        return currentRoom;
    }
}
