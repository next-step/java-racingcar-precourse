package racingcar.domain.wrap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : choi-ys
 * @date : 2022-04-25 오전 4:45
 */
public class CarNames {
    private List<String> carNames;

    private CarNames(List<String> carNames) {
        this.carNames = carNames;
    }

    public static CarNames of(String[] carNameArray){
        return new CarNames(new ArrayList<>(Arrays.asList(carNameArray)));
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
