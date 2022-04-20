package racingcar.game.car;

import racingcar.game.util.AbstractMutableList;

import java.util.List;

public class CarNames extends AbstractMutableList<CarName> {
    public CarNames(List<String> carNames) {
        super();

        for (String carName: carNames) {
            add(new CarName(carName));
        }
    }
}
