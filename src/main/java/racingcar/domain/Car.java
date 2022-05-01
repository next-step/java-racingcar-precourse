package racingcar.domain;

import racingcar.stategy.MovingStrategy;

import java.util.NoSuchElementException;

public class Car implements Comparable<Car> {

    private final String HYPHEN_FORMAT = "-";

    private final String name;
    private int position;
    private String hyphenPosition = "";

    public Car(final String name, final int position) {
        validate(name);
        this.name = name;
        this.position = position;
    }

    private void validate(final String name) {
        if (name.length() > 5) {
            GuideMessage.에러_자동차이름.printlnMessage();
            throw new NoSuchElementException(GuideMessage.에러_자동차이름.getMessage());
        }
    }

    public void move(final MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            hyphenPosition += HYPHEN_FORMAT;
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getHyphenPosition() {
        return hyphenPosition;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car car) {
        if (this.position > car.getPosition()) {
            return 1;
        }
        if (this.position == car.getPosition()) {
            return 0;
        }
        return -1;
    }

}
