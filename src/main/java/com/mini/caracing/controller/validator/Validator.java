package com.mini.caracing.controller.validator;

public class Validator {
    public static void checkBlank(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input is blank");
        }
    }

    public static void containsBlank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("Input contains blank");
        }
    }
}
