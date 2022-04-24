package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.constant.CarNameCondition;
import racingcar.constant.ExceptionMessage;
import racingcar.constant.GameCondition;
import racingcar.constant.GameMessage;
import racingcar.domain.car.CarName;
import racingcar.domain.game.Round;

public class PlayerInputView {
    private static final String NUMBER_FORMAT_REG_EXP = "^[0-9]+$";

    public List<CarName> waitForCarNameInput() {
        System.out.println(GameMessage.WAIT_FOR_PLAYER_CAR_NAME_INPUT);
        String carNames = Console.readLine();

        try {
            validateCarName(carNames);
            return toCarName(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return waitForCarNameInput();
        }
    }

    public Round waitForRoundInput() {
        System.out.println(GameMessage.WAIT_FOR_PLAYER_ROUND_COUNT_INPUT);
        String round = Console.readLine();

        try {
            validateRound(round);
            return toRound(round);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return waitForRoundInput();
        }
    }

    private List<CarName> toCarName(String receivedInput) {
        List<CarName> carNames = new ArrayList<>();
        String[] splitNames = receivedInput.split(CarNameCondition.CAR_NAME_SEPARATOR);
        validateCarNamesAreUnique(splitNames);
        for (String name : splitNames) {
            carNames.add(CarName.from(name));
        }
        return carNames;
    }

    private Round toRound(String receivedInput) {
        return Round.from(Integer.parseInt(receivedInput));
    }

    private void validateCarName(String receivedInput) {
        validateCarNameIsEmpty(receivedInput);
        validateCarNameFormat(receivedInput);
    }

    private void validateRound(String receivedInput) {
        validateRoundIsEmpty(receivedInput);
        validateRoundFormat(receivedInput);
        validateRoundNumberRange(receivedInput);
    }

    private void validateCarNameIsEmpty(String receivedInput) {
        if (receivedInput == null || receivedInput.length() == 0) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_CANNOT_BE_EMPTY);
        }
    }

    private void validateCarNameFormat(String receivedInput) {
        if (receivedInput.startsWith(CarNameCondition.CAR_NAME_SEPARATOR) || receivedInput.endsWith(CarNameCondition.CAR_NAME_SEPARATOR)) {
            throw new IllegalArgumentException(ExceptionMessage.INCOMPLETE_INPUT_PROVIDED);
        }
    }

    private void validateCarNamesAreUnique(String[] splitNames) {
        List<String> carNames = new ArrayList<>();
        for (String name : splitNames) {
            carNames.add(name);
        }

        Set<String> uniqueCarNames = new HashSet<>(carNames);

        if (carNames.size() != uniqueCarNames.size()) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_CAR_NAMES_PROVIDED);
        }
    }

    private void validateRoundIsEmpty(String receivedInput) {
        if (receivedInput == null || receivedInput.length() == 0) {
            throw new IllegalArgumentException(ExceptionMessage.ROUND_COUNT_CANNOT_BE_EMPTY);
        }
    }

    private void validateRoundFormat(String receivedInput) {
        if (!receivedInput.matches(NUMBER_FORMAT_REG_EXP)) {
            throw new IllegalArgumentException(ExceptionMessage.ROUND_COUNT_INVALID_TYPE);
        }
    }

    private void validateRoundNumberRange(String receivedInput) {
        if (Integer.parseInt(receivedInput) < GameCondition.MIN_ROUND) {
            throw new IllegalArgumentException(ExceptionMessage.ROUND_COUNT_CANNOT_LESS_THAN_ONE);
        }
    }
}
