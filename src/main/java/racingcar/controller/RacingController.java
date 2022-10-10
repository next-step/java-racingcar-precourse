package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Cars;
import racingcar.domain.Race;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static racingcar.utils.ValidationUtils.nameValidation;
import static racingcar.utils.ValidationUtils.roundValidation;
import static racingcar.view.ConsoleInput.printNameInputMessage;
import static racingcar.view.ConsoleInput.printRoundInputMessage;
import static racingcar.view.ConsoleOutput.printMessage;

public class RacingController {

    public void start() {
        Map<Integer, Race> allRace = new HashMap<>();
        String[] names = carNameInput();
        int round = raceRoundInput();
        Cars cars = new Cars(Arrays.asList(names));

        playGame(allRace, round, cars);

        printMessage("최종 우승자 : " + allRace.get(round).roundWinnersName());
    }

    private void playGame(Map<Integer, Race> allRace, int round, Cars cars) {
        for (int i = 0; i < round; i++) {
            Race race = new Race(cars, i);
            race.start();
            allRace.put(round, race);
        }
    }

    private int raceRoundInput() {
        try {
            printRoundInputMessage();
            return roundInput();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return raceRoundInput();
        }
    }

    private String[] carNameInput() {
        try {
            printNameInputMessage();
            return nameInput();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return carNameInput();
        }
    }

    private String[] nameInput() {
        return nameValidation(Console.readLine());
    }

    private Integer roundInput() {
        return roundValidation(Console.readLine());
    }


}
