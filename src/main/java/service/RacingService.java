package service;

import model.Car;
import model.Race;
import validator.Validator;
import view.InputView;
import view.OutputView;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RacingService {
    private Race race;

    public void raceStart() {
        String[] cars = createCars();
        int racingCount = inputRacingCount();
        race = new Race(cars);
        OutputView.outputMessage("");
        OutputView.outputMessage("실행결과");
        for (int i = 0; i < racingCount; i++) {
            race.racing();
            OutputView.outputMessage("");
        }
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
        Validator.validNumberFormat(input);
        Validator.validRacingCount(input);
        return Integer.parseInt(input);
    }

    private String[] removeDuplicates(String[] array) {
        Set<String> set = new LinkedHashSet<>(Arrays.asList(array));
        return set.toArray(new String[0]);
    }

}
