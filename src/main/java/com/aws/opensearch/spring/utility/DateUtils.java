package com.aws.opensearch.spring.utility;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class DateUtils {

    public final static DateTimeFormatter DEFAULT_DATE_PATTERN = DateTimeFormatter.ofPattern("ddMMyyyy");
    public final static DateTimeFormatter DEFAULT_DATETIME_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
    public static final ZoneId DEFAULT_ZONE_ID = ZoneId.of("UTC");

    public static String dateToString(LocalDate dateTime) {
        return dateTime == null ? null
            : dateTime.format(DEFAULT_DATE_PATTERN);
    }

    public static LocalDate getNextDayAsString(String dateTime) {
        return dateTime == null ? null : parseDate(dateTime).plusDays(1);
    }

    public static LocalDate getLastDayOfFutureMonthAsString(String dateTime, int numOfMonth) {
        return dateTime == null ? null
            : parseDate(dateTime).plusMonths(numOfMonth).with(TemporalAdjusters.lastDayOfMonth());
    }

    public static LocalDate parseDate(String dateStr) {
        return LocalDate.parse(dateStr, DEFAULT_DATE_PATTERN);
    }
}
