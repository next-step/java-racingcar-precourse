package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.ErrorConstant;
import racingcar.constant.RacingConstant;
import racingcar.domain.RacingRound;
import racingcar.domain.car.CarName;

import java.util.ArrayList;
import java.util.List;

public class ReadyView {



    public List<CarName> createCarNames() {
        System.out.println(RacingConstant.MESSAGE_INPUT_CAR_NAME);
        String nameBulk = Console.readLine();
        String[] names = nameBulk.split(RacingConstant.COMMA);
        return generateCarNameArrayToList(names);
    }

    private List<CarName> generateCarNameArrayToList(String[] names) {
        List<CarName> carNames = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
//            carNames.add(new CarName(names[i]));
            carNames.add(CarName.from(names[i]));
        }
        return carNames;
    }

    public RacingRound createRacingRound() {
        System.out.println(RacingConstant.MESSAGE_INPUT_CAR_ROUND);
        String round = Console.readLine();
        return generateRacingRoundStringToInt(round);
    }

    public RacingRound generateRacingRoundStringToInt(String roundString) {
        validateRacingRound(roundString);
        RacingRound racingRound = new RacingRound(Integer.parseInt(roundString));
        return racingRound;
    }

    public void validateRacingRound(String roundString) {
        if (roundString == null || roundString.isEmpty()) {
            throw new IllegalArgumentException(ErrorConstant.ERROR_ROUND_IS_NOT_EMPTY);
        }

        if (!roundString.matches(RacingConstant.REG_EXP_IS_NUMBER)) {
            throw new IllegalArgumentException(ErrorConstant.ERROR_ONLY_NUMBER);
        }
    }
}
