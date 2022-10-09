package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RacingCars;
import racingcar.model.RoundNumber;

import static racingcar.constant.GuideMessage.INPUT_CAR_NAME;
import static racingcar.constant.GuideMessage.INPUT_RACING_ROUND_NUMBER;

public class RacingArgument {

    public RacingCars inputRacingCars() {
        String carNames = inputCarNameText();
        return generatorRacingCarsByInputCarNames(carNames);
    }

    public RoundNumber inputRacingRoundNumber() {
        String roundNumber = inputRoundNumberText();
        return generatorRacingRoundNumberByNumber(roundNumber);
    }

    private String inputCarNameText() {
        System.out.println(INPUT_CAR_NAME);
        return Console.readLine();
    }

    private String inputRoundNumberText() {
        System.out.println(INPUT_RACING_ROUND_NUMBER);
        return Console.readLine();
    }

    private RacingCars generatorRacingCarsByInputCarNames(String carNames) {
        RacingCars racingCars = new RacingCars();
        racingCars.initRacingCars(carNames);
        return racingCars;
    }

    private RoundNumber generatorRacingRoundNumberByNumber(String number) {
        RoundNumber roundNumber = new RoundNumber();
        roundNumber.initRoundNumber(number);
        return roundNumber;
    }

    public static void printErrorMessage(String message) {
        System.out.println(message);
    }

}
