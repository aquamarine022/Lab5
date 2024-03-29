package me.masha;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Constants {
    /**
     * Global format for date
     */
    public static final String DATE_FORMAT = "dd.MM.yyyy";
    /**
     * Global format for time
     */
    public static final String TIME_FORMAT = "HH:mm";
    /**
     * Global universal formatter for DateTime objects
     */
    public static final DateTimeFormatter formatter = new DateTimeFormatterBuilder()
            .appendPattern(DATE_FORMAT)
            .appendPattern(" " + TIME_FORMAT)
            .toFormatter();
}
