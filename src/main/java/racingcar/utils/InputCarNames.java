package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InputCarNameIllegarArgumentException;

import java.util.HashSet;
import java.util.Set;

import static racingcar.utils.RacingCarConstants.CAR_NAME_SPLIT_CHARACTER;
import static racingcar.utils.RacingCarConstants.MIN_PARTICIPANT_CARS;
import static racingcar.utils.RacingCarConstants.MSG_CAR_NAME_DUPLICATE_EXCEPTION;
import static racingcar.utils.RacingCarConstants.MSG_GAME_PARTICIPANT_ILLEGAR_EXCEPTION;

public class InputCarNames {
    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분");
        String[] carNames = Console.readLine().split(CAR_NAME_SPLIT_CHARACTER);
        if (isNotEnoughParticipant(carNames)) {
            throw new InputCarNameIllegarArgumentException(MSG_GAME_PARTICIPANT_ILLEGAR_EXCEPTION);
        }
        if (isDuplicated(carNames)) {
            throw new InputCarNameIllegarArgumentException(MSG_CAR_NAME_DUPLICATE_EXCEPTION);
        }

        return carNames;
    }

    private static boolean isNotEnoughParticipant(String[] carNames) {
        if (carNames.length < MIN_PARTICIPANT_CARS) {
            return true;
        }
        return false;
    }

    private static boolean isDuplicated(String[] carNames) {
        Set<String> checkDupclicate = new HashSet<>();
        for (int i = 0; i < carNames.length; i++) {
            checkDupclicate.add(carNames[i].trim());
        }
        if (checkDupclicate.size() != carNames.length) {
            return true;
        }
        return false;
    }
}
