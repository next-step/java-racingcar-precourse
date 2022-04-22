package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

import racingcar.common.PrintMessage;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingRounds;

public class RacingController {
    public static final String REGEX = ",";

    private Cars cars;
    private RacingGame game;
    private RacingRounds rounds;

    public RacingController() {
        setCars();
        setRacingRounds();
        PrintMessage.printResultHeaderMessage();
        setRacingGame();
    }

    private void setCars() {
        try {
            PrintMessage.printInputNamesMessage();
            String inputNames = Console.readLine();
            cars = new Cars(Arrays.asList(inputNames.split(REGEX)));
        } catch (IllegalArgumentException exception) {
            PrintMessage.print(exception.getMessage());
            setCars();
        }
    }

    private void setRacingRounds() {
        try {
            PrintMessage.printInputNumberMessage();
            String inputNumber = Console.readLine();
            rounds = new RacingRounds(inputNumber);
        } catch (IllegalArgumentException exception) {
            PrintMessage.print(exception.getMessage());
            setRacingRounds();
        }
    }

    private void setRacingGame() {
        game = new RacingGame(cars, rounds);
    }

    public void playGame() {
        game.playGame();
    }

    public void endGame() {
        game.endGame();
    }
}
