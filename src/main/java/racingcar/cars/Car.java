package racingcar.cars;

import racingcar.firstcollections.Positive;
import racingcar.utils.ValidationUtils;

public class Car implements Comparable<Car> {

    public static final int MINIMUM_SPEED = 0;
    public static final int MAXIMUM_SPEED = 9;
    private static final int FIXED_SPEED = 1;
    private static final int BOUNDED_SPEED = 4;
    private static final int STOP_SPEED = 0;
    private static final String ERROR_MESSAGE = "자동차 이름은 %d 글자까지 입력 가능합니다.(빈 문자열 불가!)";

    private final String name;
    private final Positive distance;

    public Car(final String name) {
        if (!ValidationUtils.validateCarName(name, ValidationUtils.CAR_NAME_LENGTH_LIMIT)) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE, ValidationUtils.CAR_NAME_LENGTH_LIMIT));
        }
        this.name = name;
        this.distance = new Positive(Positive.MIN_VALUE);
    }

    public Car(final String name, Positive distance) {
        if (!ValidationUtils.validateCarName(name, ValidationUtils.CAR_NAME_LENGTH_LIMIT)) {
            throw new IllegalArgumentException(String.format(ERROR_MESSAGE, ValidationUtils.CAR_NAME_LENGTH_LIMIT));
        }
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return this.name;
    }

    public long getDistance() {
        return this.distance.get();
    }

    public void move(final int randomNumber) {
        for (int i = 0; i < accelerator(randomNumber); i++) {
            this.distance.add();
        }
    }

    public boolean isMaxPosition(final Car car) {
        return this.getDistance() == car.getDistance();
    }

    @Override
    public int compareTo(Car other) {
        return Long.compare(this.getDistance(), other.getDistance());
    }

    private int accelerator(final int randomNumber) {
        if (BOUNDED_SPEED <= randomNumber) {
            return FIXED_SPEED;
        }
        return STOP_SPEED;
    }
}
