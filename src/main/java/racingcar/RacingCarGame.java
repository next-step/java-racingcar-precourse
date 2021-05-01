package racingcar;

import utils.RandomNumberGenerator;
import utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private static final String ILLEGAL_NAME_MESSAGE = "자동차 이름은 공백을 포함하지 않고, 중복되지 않아야 합니다.";
    private static final String ILLEGAL_COUNT_MESSAGE = "시도할 횟수는 0보다 큰 숫자여야 합니다.";
    private final Cars cars;
    private final int count;

    public RacingCarGame(String input, String count) {
        if (ValidationUtils.isBlank(input)) {
            throw new IllegalArgumentException(ILLEGAL_NAME_MESSAGE);
        }
        if (ValidationUtils.isNumber(count)) {
            throw new IllegalArgumentException(ILLEGAL_COUNT_MESSAGE);
        }

        this.cars = mapCar(input);
        this.count = Integer.parseInt(count);
    }

    public void start() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        for (int i = 0; i < count; i++) {
            cars.play(generator);
        }
        cars.showGameWinner();
    }

    private Cars mapCar(String input) {
        String[] names = input.split(",");
        if (ValidationUtils.isDuplicated(names)) {
            throw new IllegalArgumentException(ILLEGAL_NAME_MESSAGE);
        }
        List<Car> list = new ArrayList<>();
        for (String name : names) {
            list.add(new Car(name));
        }
        return new Cars(list);
    }
}
