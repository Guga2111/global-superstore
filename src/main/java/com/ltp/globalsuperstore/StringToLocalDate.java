package com.ltp.globalsuperstore;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Component
public class StringToLocalDate implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String source) {
        try {
            // Primeiro, tente converter o formato 'yyyy-MM-dd' (ISO, do input date)
            return LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException e) {
            try {
                // Caso falhe, tente o formato 'dd-MM-yyyy'
                return LocalDate.parse(source, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            } catch (DateTimeParseException ex) {
                throw new IllegalArgumentException("Data inválida. Use o formato dd-MM-yyyy.");
            }
        }
    }
}
