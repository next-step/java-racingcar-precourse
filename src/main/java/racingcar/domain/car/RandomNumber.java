package racingcar.domain.car;

import racingcar.global.config.CarConfig;
import racingcar.global.utils.NumberGenerateUtils;

public class RandomNumber {
    int number;

    public RandomNumber() {
        this.number = NumberGenerateUtils.createRandomNumber(CarConfig.MIN_CAR_GO_FORWARD, CarConfig.MAX_CAR_GO_FORWARD);
    }

    public int getNumber() {
        return number;
    }
}
