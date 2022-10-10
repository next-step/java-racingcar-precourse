package racingcar.entities;

import racingcar.utils.ConsoleView;

import java.util.ArrayList;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class NamesInput {

    public static final String SPLIT_EXPRESSION = ",";
    public static final int NAME_MAX_LENGTH = 5;
    public static final String PROCEED_GAME_WITH_ONE_CAR = "1";
    public static final String RE_READ_LINE_CODE = "2";
    private String[] names;

    public NamesInput(String input) {
        while (true) {
            try {
                divideNamesFromInput(input);
                validateNameInput();
                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input = readLine();
            }
        }
    }

    private void validateNameInput() throws IllegalArgumentException{
        if (Arrays.equals(this.names, new String[]{""}))
            throw new IllegalArgumentException(ErrorScenario.NULL_NAME_INPUT.getErrorPhrases());
        if (this.names.length == 1)
            checkIfGameStartsWithOneCar();
        for (String name : this.names)
            validateNameLength(name);
    }

    private void divideNamesFromInput(String input) {
        try {
            this.names = input.split(SPLIT_EXPRESSION);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorScenario.WRONG_NAME_INPUT_BASIC.getErrorPhrases());
        }
    }

    private void checkIfGameStartsWithOneCar() {
        ConsoleView consoleView = new ConsoleView();
        IsGameProceedWithOneCar isGameProceedWithOneCar = consoleView.getIfGameStartsWithOneCar();
        if (isGameProceedWithOneCar.getInput().equals(RE_READ_LINE_CODE))
            throw new IllegalArgumentException(ErrorScenario.ASK_RACING_CARS_NAME_AGAIN.getErrorPhrases());
    }

    private void validateNameLength(String name)throws IllegalArgumentException {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorScenario.OVER_MAX_NAME_LENGTH.getErrorPhrases());
//            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public String[] getNames() {
        return names;
    }

    public ArrayList<Car> constructCars() {
        ArrayList<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
