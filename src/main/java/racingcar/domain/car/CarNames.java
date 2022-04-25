package racingcar.domain.car;

import java.util.Arrays;
import java.util.List;

public class CarNames {

    private final List<String> carNames;

    public CarNames(String inputString) {
        this.carNames = Arrays.asList(inputString.split("\\s*,\\s*"));
    }

    public int getCount() {
        return carNames.size();
    }

    public String getCarName(int index) {
        return carNames.get(index);
    }

    public List<String> getCarNames() {
        return this.carNames;
    }
}
