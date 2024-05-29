package com.mini.caracing.controller.validator;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    public static void validateCarNames(String carNamesInput) throws IllegalArgumentException {
        checkBlank(carNamesInput);
        containsBlank(carNamesInput);
        containsBlank(carNamesInput);
        checkNoCarName(carNamesInput);
        checkCarNameLengthOver(carNamesInput);
        checkDuplicatedCarName(carNamesInput);
    }

    public static void validateTotalMove(String totalMoveInput) throws IllegalArgumentException {
        checkNotNumber(totalMoveInput);
        checkBelowZero(totalMoveInput);
    }

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

    public static void checkNotNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("Total Move is not integer number");
        }
    }

    public static void checkBelowZero(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException("Total move is below zero");
        }
    }
}
