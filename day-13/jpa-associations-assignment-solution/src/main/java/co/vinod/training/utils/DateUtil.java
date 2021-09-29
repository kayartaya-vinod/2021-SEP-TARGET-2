package co.vinod.training.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {

    private DateUtil() {
    }

    static final String pattern = "yyyy-MM-dd"; // ISO format

    public static String toString(Date dt) {
        return new SimpleDateFormat(pattern).format(dt);
    }

    public static Date toDate(String dateStr) {
        try {
            return new SimpleDateFormat(pattern).parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("Date not in format - " + pattern);
        }
    }
}
