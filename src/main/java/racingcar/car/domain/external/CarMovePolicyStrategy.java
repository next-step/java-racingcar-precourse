package racingcar.car.domain.external;

import racingcar.car.domain.models.CarMovePolicy;

public interface CarMovePolicyStrategy {

    CarMovePolicy getCarMovePolicy();
}
