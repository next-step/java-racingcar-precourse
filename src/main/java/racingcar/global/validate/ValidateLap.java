package racingcar.global.validate;

import racingcar.domain.InputData;
import racingcar.global.config.GameConfig;

public class ValidateLap {

    private ValidateLap() {}

    public static boolean isValidLapSize(InputData inputData) {
        int lapData = Integer.parseInt(inputData.getInputData());
        return GameConfig.MIN_LAP_SIZE < lapData&&lapData <= GameConfig.MAX_LAP_SIZE;
    }
}
