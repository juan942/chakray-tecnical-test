package com.example.demo.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static final ZoneId MADAGASCAR_ZONE = ZoneId.of("Indian/Antananarivo");

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public static String format(LocalDateTime localDateTime) {
        return FORMATTER.format(localDateTime);
    }

    public static LocalDateTime nowInMadagascar() { return LocalDateTime.now(MADAGASCAR_ZONE); }
}
