package net.plantsystem.application.utils;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @author rames on 2023-03-16
 */
public class DateUtils {

    public static Long getTimeInMillisecondsFromLocalDate() {
        LocalDateTime localDate = LocalDateTime.now();
        return Timestamp.valueOf(localDate).getTime();
    }

    public static Long getDifferenceBetweenTwoTime(Long startTime) {
        return getTimeInMillisecondsFromLocalDate() - startTime;
    }

}
