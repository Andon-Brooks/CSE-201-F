/**
 * Class: Clock
 * 
 * Author: Group F CSE 201
 * 
 * This class is to represent a clock and track the time in the game
 */
public class Clock {
    // Variable to store minutes
    private int minutes;
    // Variable to store hours
    private int hours;

    /*
     * Constructor method for the clock class
     */
    public Clock(int hour, int min) {
        // Can be changed to change game difficulty
        this.hours = hour;
        this.minutes = min;
    }
    
    /**
     * This method is to deduct time penalties from the total game time
     * 
     * @param minutesToDeduct the total minutes that are to be deducted
     */
    public void deductTime(int minutesToDeduct) {
        minutes -= minutesToDeduct;

        while (minutes < 0) {
            minutes += 60;
            hours--;
        }

        // Check if time has run out
        if (hours <= 0 && minutes <= 0) {
            hours = 0;
            minutes = 0;
            Game.gameOver = true;
        }
        System.out.println(printTime());
    }
    
    /**
     * Getter Method for the hours variable
     * 
     * @return hours remaining in the game
     */
    public int getHours() {
        return hours;
    }

    /**
     * Getter method for the minutes variable
     * 
     * @return current minutes remaining in the game
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * Getter method that puts the remaining minutes and hours into a readable
     * string format
     * 
     * @return the string to be printed
     */
    public String printTime() {
        return "Remaining Hours: " + this.hours + " | Remaining Minutes: "
                + this.minutes;
    }
}
