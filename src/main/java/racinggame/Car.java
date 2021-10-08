package racinggame;

import java.util.Objects;

/**
 * Name : Car <br/>
 * Description : 자동차 클래스
 */
public class Car {
    public static final int MAX_NAME_LENGTH = 5;
    public static final int MIN_NAME_LENGTH = 1;
    private String name;

    public Car() {
        throw new IllegalArgumentException("자동차 이름은 필수 입니다. 입력해 주세요.");
    }

    public Car(String name) {
        if (isInvalidName(name))  {
            throw new IllegalArgumentException("자동차 이름은 1~5자로 입력해 주세요.");
        }
        this.name = name;
    }

    private boolean isInvalidName(String name) {
        return name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
