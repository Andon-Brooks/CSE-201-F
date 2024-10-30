
public static class Clock {
    private int minutes;
    private int hours;

    public Clock(){
        this.hours = 12;
        this.minutes = 0;
    }

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
        
        getTime();
    }

    public String getTime() {
        return System.out.println("Hour: " + this.hours + " Minutes: " + this.minutes + " remember the owner returns at Hour: 3 and Minutes: 0");   
    }
}