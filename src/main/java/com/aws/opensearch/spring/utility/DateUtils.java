package com.aws.opensearch.spring.utility;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private final static String DEFAULT_DATE_PATTERN = "yyyyMMdd_HHmmss";
    public static final ZoneId DEFAULT_ZONE_ID = ZoneId.of("UTC");

    public static String getDateAsString(LocalDateTime dateTime) {
        DateTimeFormatter formatter  = DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN);
        return dateTime.format(formatter);
    }
}
