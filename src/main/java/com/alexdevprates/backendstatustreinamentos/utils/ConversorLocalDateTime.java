package com.alexdevprates.backendstatustreinamentos.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConversorLocalDateTime {

    public static LocalDateTime parseStringToLocalDateTime(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd'T'HH:mm:ss");
        return LocalDateTime.parse(dateString, formatter);
    }
}
