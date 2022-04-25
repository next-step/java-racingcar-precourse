package racingcar.game;

import static racingcar.utils.StringUtils.hasNotText;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import racingcar.car.CarName;

public class InputCarNames {
    private static final String SPLITTER = ",";
    private List<CarName> carNames;

    private InputCarNames(final List<CarName> carNames) {
        this.carNames = carNames;
    }

    public static InputCarNames valueOf(final String carNamesString) {
        validateCarNames(carNamesString);
        List<CarName> carNameList = new ArrayList<>();

        final String[] carNames = carNamesString.split(SPLITTER);
        for (String carName : carNames) {
            carNameList.add(CarName.of(carName.trim()));
        }

        return new InputCarNames(carNameList);
    }

    public <T> List<T> mapTo(final Function<CarName, T> function) {
        List<T> tList = new ArrayList<>();

        for (CarName carName : carNames) {
            tList.add(function.apply(carName));
        }

        return tList;
    }

    public int count() {
        return this.carNames.size();
    }

    private static void validateCarNames(final String carNamesString) {
        if (hasNotText(carNamesString)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름을 입력해주세요.");
        }

        if (carNamesString.split(SPLITTER).length <= 0) {
            throw new IllegalArgumentException("[ERROR] 최소한 하나 이상의 자동차의 이름을 넣어주세요.");
        }
    }
}
