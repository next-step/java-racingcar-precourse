package racingcar.model.racing;

import racingcar.constant.ErrorMessage;
import racingcar.model.car.Car;
import racingcar.model.car.CarConfig;
import racingcar.model.car.Entries;

import java.util.ArrayList;
import java.util.List;

public class RacingBuilder {
    private static final String CAR_NAME_SPLITTER = "\\s*,\\s*"; // 쉼표(,)로 구분해서 앞뒤 공백 제거

    private Entries entries;
    private LapCount lapCount;

    RacingBuilder() {
    }

    public RacingBuilder carNames(String carNamesWithComma) {
        this.entries = createEntries(carNamesWithComma);
        return this;
    }

    private Entries createEntries(String carNamesWithComma) {
        List<Car> createCars = new ArrayList<>();

        String[] carNames = splitCarNames(carNamesWithComma);
        for (String carName : carNames) {
            createCars.add(new Car(carName));
        }

        return new Entries(createCars);
    }

    private String[] splitCarNames(String carNamesWithComma) {
        validateCarNames(carNamesWithComma);

        String carNames = carNamesWithComma.trim(); // 앞뒤 공백 제거
        return carNames.split(CAR_NAME_SPLITTER);
    }

    private void validateCarNames(String carNamesWithComma) {
        if (carNamesWithComma == null) {
            throw new IllegalArgumentException(
                    String.format(ErrorMessage.INVALID_CAR_NAMES_LENGTH, CarConfig.MIN_CAR_NAME_LENGTH,
                                  CarConfig.MAX_CAR_NAME_LENGTH));
        }
    }

    public RacingBuilder lapCount(String lapCount) {
        this.lapCount = new LapCount(lapCount);
        return this;
    }

    public Racing build() {
        return new Racing(this.entries, this.lapCount);
    }
}
