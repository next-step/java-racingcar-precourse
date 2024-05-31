package service;

import validator.Validator;
import view.InputView;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RacingService {
    public void raceStart() {
        String[] cars = createCars();
        int racingCount = inputRacingCount();
    }

    public String[] createCars() {
        String input = InputView.inputCarList();
        input = input.replaceAll(" ", "");
        String[] carArray = input.split(",");
        Validator.validNameLength(carArray);
        return removeDuplicates(carArray);
    }

    public int inputRacingCount() {
        String input = InputView.inputRacingCount();
        Validator.validRacingCount(input);
        return Integer.parseInt(input);
    }

    private String[] removeDuplicates(String[] array) {
        Set<String> set = new LinkedHashSet<>(Arrays.asList(array));
        return set.toArray(new String[0]);
    }
}
