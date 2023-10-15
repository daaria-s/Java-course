package hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLOutput;

public final class Task1 {

    private Task1() {
    }

    public static int minutesToSeconds(String stringTime) {
        String[] time = stringTime.split(":");
        if (time.length == 2) {
            int minutes = Integer.parseInt(time[0]);
            int seconds = Integer.parseInt(time[1]);
            if (seconds < 60 && minutes >= 0 && seconds >= 0) {
                return minutes * 60 + seconds;
            }
        }
        return -1;
    }


}




