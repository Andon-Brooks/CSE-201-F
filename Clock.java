/*
* This class is to represent a clock and trak the time in the game
*/
public class Clock {
    // Variable to store minutes
    private int minutes;
    // Variable to store hours
    private int hours;
    // Variable to indicate if the game is paused
    private boolean paused;

    /*
    * Constructor method for the clock class
    */
    public Clock() {
        // I gave 4 hours of time to find Gary. The owner is gone from 12:00 pm to 4:00 pm
        this.hours = 4;     // I feel it's easier to just set a time limit and in the start game description just explain the hours the owner is gone???
        this.minutes = 0;
        this.paused = false;
    }

    public void addTime(int minutesToAdd) {
        if (!paused) {
            minutes += minutesToAdd;
            while (minutes >= 60) {
                minutes -= 60;
                hours++;
            }
            if (hours >= 4) {
                hours = 4;
                minutes = 0;
            }
            System.out.println(printTime());
        }
    }

    public void deductTime(int minutesToDeduct) {
        if (!paused && !Game.gameOver) {  // Check if game is not already over
            minutes -= minutesToDeduct;

            while (minutes < 0) {
                minutes += 60;
                hours--;
            }

            // Check if time has run out
            if (hours <= 0 && minutes <= 0) {
                hours = 0;
                minutes = 0;

                if (!Game.hasCaughtGary) {
                    Game.gameOver = true;
                    System.out.println("\nTime has run out! Your owner has returned home, and Gary is still loose!");
                    Game.displayEndGameSummary();  // Display the end game summary for a loss
                }
            } else if (!Game.gameOver) {
                System.out.println(printTime());
            }
        }
    }



    public void pause() {
        paused = true;
    }
    public void resume() {
        paused = false;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public String getRemainingTime() {
        return hours + " hours and " + minutes + " minutes ";   // Remaining time until the owner arrives home.
    }

    /**
     * Prints the time as a string to guide the user
     * 
     * @return the string to be printed
     */
    public String printTime() {
        return "\nRemaining Hours: " + this.hours + " | Remaining Minutes: " + this.minutes + " | Make sure to find Gary before time runs out!\n";
    }

}
