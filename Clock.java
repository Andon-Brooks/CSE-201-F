/**
 * This class is to run the game clock that determines
 * if the player wins or loses
 */
public class Clock {
    // The minutes of the time, should be 0 <= 60
    private int minutes;
    // The hours of the time
    private int hours;

    /**
     * Constructor for the clock method
     * sets the time to the game starting time
     */
    public Clock(){
        this.hours = 12;
        this.minutes = 0;
    }
    
    /**
     * Adds time to the game clock according to specified amount
     * 
     * @param minutesToAdd specified minutes to add to the time
     */
    public void addTime(int minutesToAdd) {
        minutes += minutesToAdd;
        while(minutes >= 60){
            minutes -= 60;
            hours++;
        }
        if(hours > 12){
            hours = 0;
            hours++;
        } 
        if(hours == 3){
            Game.gameOver = true;
        }
        // this is to print the time, can remove this if needed
        System.out.println(printTime());
    }
    
    /**
     * Prints the time as a string to guide the user
     * 
     * @return the string to be printed
     */
    public String printTime() {
        return "Hour: " + this.hours + " Minutes: " + this.minutes + " remember the owner returns at Hour: 3 and Minutes: 0";
    }
}   