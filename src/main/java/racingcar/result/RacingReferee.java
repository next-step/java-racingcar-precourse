package racingcar.result;

import racingcar.car.CarGroup;

@FunctionalInterface
public interface RacingReferee {

    static RacingReferee ofDefault() {
        return DefaultRacingReferee.INSTANCE;
    }

    RacingResult determine(CarGroup carGroup);
}
