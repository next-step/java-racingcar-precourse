package racingcar.ui;

import java.util.List;

public class CarNamesInput {
    private final List<String> carNames;

    public CarNamesInput(List<String> carNames) {
        this.carNames = carNames;
    }

    public List<String> getCarNames() {
        return this.carNames;
    }
}
