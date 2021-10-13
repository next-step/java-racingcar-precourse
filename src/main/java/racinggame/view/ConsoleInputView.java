package racinggame.view;

import nextstep.utils.Console;
import racinggame.model.RacingCar;

import java.util.ArrayList;
import java.util.List;

import static racinggame.constants.Messages.MOVE_TRY_NUM_INVALID;
import static racinggame.constants.Messages.CAR_NAME_USER_INPUT;
import static racinggame.constants.Messages.CAR_MOVE_TRY_USER_INPUT;
import static racinggame.constants.Messages.ERROR_MESSAGE;
import static racinggame.constants.Messages.CAR_PARTIPCIPANT_INVALID;
import static racinggame.constants.RacingCarConstants.CAR_NAME_INPUT_DELIMETER;
import static racinggame.constants.RacingCarConstants.carNameInputPattern;
import static racinggame.constants.RacingCarConstants.carMoveTryInputPattern;

public class ConsoleInputView {
    public static List<RacingCar> getUserInputCarNames() {
        System.out.println(CAR_NAME_USER_INPUT.getMessage());
        String userInputCarNames = Console.readLine();
        boolean regexValidRange = carNameInputPattern.matcher(userInputCarNames).matches();
        if (!regexValidRange) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getMessage() + CAR_NAME_USER_INPUT.getMessage());
        }

        String[] carNames = userInputCarNames.split(CAR_NAME_INPUT_DELIMETER);

        if (carNames.length < 2) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getMessage() + CAR_PARTIPCIPANT_INVALID.getMessage());
        }

        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            RacingCar racingCar = RacingCar.newInstance(carName);
            racingCars.add(racingCar);
        }
        return racingCars;
    }

    public static int getUserInputCarMoveTryCount() {
        System.out.println(CAR_MOVE_TRY_USER_INPUT.getMessage());
        String userInputCarMoveTryCount = Console.readLine();
        boolean regexValidRange = carMoveTryInputPattern.matcher(userInputCarMoveTryCount).matches();
        if (!regexValidRange) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getMessage() + MOVE_TRY_NUM_INVALID.getMessage());
        }
        return Integer.parseInt(userInputCarMoveTryCount);
    }
}
