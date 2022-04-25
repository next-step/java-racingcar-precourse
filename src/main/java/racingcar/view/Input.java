package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.CarNames;
import racingcar.domain.RacingCars;
import racingcar.utils.RandomNumberPicker;

import static racingcar.view.ErrorMessage.*;
import static racingcar.view.InitialOutput.RACING_INPUT_MESSAGE;
import static racingcar.view.InitialOutput.TOTAL_ROUND_INPUT_MESSAGE;

public class Input {

    private RacingCars racingCars;
    private int totalRound;
    private CarNames carNames;

    public void input() {
        inputRacingCars();
        inputTotalRound();
    }

    private void inputRacingCars() {
        RACING_INPUT_MESSAGE.print();

        try {
            carNames = new CarNames(Console.readLine());
            racingCars = new RacingCars(new RandomNumberPicker(), carNames.getCarNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputRacingCars();
        }
    }

    private void inputTotalRound() {
        TOTAL_ROUND_INPUT_MESSAGE.print();

        try {
            InputNumber inputNumber = new InputNumber(Console.readLine());
            totalRound = inputNumber.number;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputTotalRound();
        }
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }

    public int getTotalRound() {
        return totalRound;
    }

    public CarNames getCarNames() {
        return carNames;
    }

    private static class InputNumber {

        private final int number;

        public InputNumber(String input) {
            try {
                this.number = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(DEFAULT.getMessage() + ONLY_NUMBER_INPUT.getMessage());
            }
        }
    }

}
