package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.security.InvalidParameterException;

public class Car {
    private final static String CAR_NAME_TOO_LONG = "[ERROR] 자동차 이름은 5자 이내로 작성해 주세요.";

    private Distance distance;
    private String name;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
        this.distance = new Distance();
    }

    public Distance getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public void move() {
        if (Randoms.pickNumberInRange(1, 9) > 3) {
            distance.addDistance();
        }
    }


    public void validateCarName(String name) {
        if (name.length() > 5) {
            throw new InvalidParameterException(Car.CAR_NAME_TOO_LONG);
        }
    }
}
