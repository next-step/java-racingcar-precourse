package com.mini.caracing.controller.validator;

import java.util.HashSet;
import java.util.Set;

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

    public static void checkNoCarName(String input) {
        if (input.matches("^,.*") || input.matches(".*,$")) {
            throw new IllegalArgumentException("Input has no car name");
        }
    }

    public static void checkCarNameLengthOver(String input) {
        for (String carName : input.split(",")) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("Car name is longer than 5");
            }
        }
    }

    public static void checkDuplicatedCarName(String input) {
        Set<String> carNameSet = new HashSet<>();

        for (String carName : input.split(",")) {
            if (!carNameSet.add(carName)) {
                throw new IllegalArgumentException("Car names are duplicated");
            }
        }
    }
}
