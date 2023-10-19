package edu.hw1;



public final class Task1 {
    private static final int SECONDS_IN_MINUTES = 60;

    private Task1() {
    }

    public static int minutesToSeconds(String stringTime) {
        String[] time = stringTime.split(":");
        if (time.length == 2) {
            int minutes = Integer.parseInt(time[0]);
            int seconds = Integer.parseInt(time[1]);
            if (seconds < SECONDS_IN_MINUTES && minutes >= 0 && seconds >= 0) {
                return minutes * SECONDS_IN_MINUTES + seconds;
            }
        }
        return -1;
    }

}




