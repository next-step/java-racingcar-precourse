package com.game.global.utils;

public class CsvUtils {

    public static final String EMPTY_CSV_STRING = "입력된 자동차 목록이 비어있습니다.";


    public static String[] makeStringArray(String csvString) {
        validateInputString(csvString);
        final String[] csvArray = csvString.replaceAll(" ", "").split(",");
        validateStringArray(csvArray);
        return csvArray;
    }

    private static void validateInputString(String value) {
        if (value == null || value.length() == 0) {
            throw new IllegalArgumentException(EMPTY_CSV_STRING);
        }
    }

    private static void validateStringArray(String[] csvArray) {
        if (csvArray.length == 0) {
            throw new IllegalArgumentException(EMPTY_CSV_STRING);
        }
    }

}
