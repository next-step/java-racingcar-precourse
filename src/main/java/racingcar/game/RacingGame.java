package racingcar.game;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.util.Lists;
import racingcar.domain.CarName;
import racingcar.domain.Racing;
import racingcar.domain.RacingCar;
import racingcar.exception.EmptyStringArgumentException;
import racingcar.exception.InputNotIntegerArgumentException;
import racingcar.ui.Output;

import java.util.List;

import static racingcar.ui.Output.ERROR_NOT_ALLOW_EMPTY_CAR_NAMES_MESSAGE;
import static racingcar.ui.Output.ERROR_ONLY_ABLE_TO_INPUT_AS_NUMBER_MESSAGE;

public class RacingGame extends Game {

    public static RacingGame newInstance() {
        return new RacingGame();
    }

    @Override
    public void play() {
        List<RacingCar> racingCarList = getRacingCars();
        int racingCount = getRacingCount();
        Racing racing = new Racing(racingCount, racingCarList);
        racing.race();
        if (racing.isEnd()) racing.showRacingResult();
    }

    private List<RacingCar> getRacingCars() {
        try {
            String[] carNames = getCarNames();
            return convertStringArrayToList(carNames);
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return getRacingCars();
        }
    }

    private int getRacingCount() {
        try {
            Output.printInputRacingCountMessage();
            String racingCountInput = Console.readLine().trim();
            validateEmptyString(racingCountInput);
            return convertStringToInteger(racingCountInput);
        } catch (IllegalArgumentException e) {
            Output.printErrorMessage(e.getMessage());
            return getRacingCount();
        }
    }

    private List<RacingCar> convertStringArrayToList(String[] carNames) {
        List<RacingCar> racingCars = Lists.newArrayList();
        for (String carName : carNames) {
            racingCars.add(new RacingCar(CarName.of(carName)));
        }
        return racingCars;
    }

    private String[] getCarNames() {
        Output.printInputCartNameMessage();
        String carNamesInput = Console.readLine().trim();
        validateEmptyString(carNamesInput);
        return carNamesInput.split(",");
    }

    private void validateEmptyString(String value) {
        if (value.isEmpty()) throw new EmptyStringArgumentException(ERROR_NOT_ALLOW_EMPTY_CAR_NAMES_MESSAGE);
    }

    private static int convertStringToInteger(String value) {
        if (!value.chars().allMatch(Character::isDigit)) throw new InputNotIntegerArgumentException(ERROR_ONLY_ABLE_TO_INPUT_AS_NUMBER_MESSAGE);
        return Integer.parseInt(value);
    }
}
