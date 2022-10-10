package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.NumberRule;
import racingcar.utils.RacingCarStringUtils;

public class Car {

    private String name;

    public Car(String name) {
        RacingCarStringUtils.checkNotEmpty(name);
        RacingCarStringUtils.checkMaxLength(name, NumberRule.NAME_LENGTH_LIMIT.getValue());
        this.name = name;
    }


    public boolean isForward() {
        int randomNumber = Randoms.
                pickNumberInRange(NumberRule.MIN_RANDOM_NUMBER.getValue(), NumberRule.MAX_RANDOM_NUMBER.getValue());
        if(randomNumber >= NumberRule.MIN_MOVING_FORWARD_RANDOM_NUMBER.getValue()) return true;
        return false;
    }

    public String getName() {
        return this.name;
    }
}
