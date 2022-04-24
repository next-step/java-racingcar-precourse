package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.error.ErrorMessage;

import java.util.Collections;

public class Car {
    private static final int NAME_MAX_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 1;
    private static final int IS_MOVE = 4;
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;
    private static final String DASH = "-";
    private static final String DASH_DELIMITER = "";
    private static final String PRINT_DISTANCE_DELIMITER = " : ";
    private final String name;
    private int distance = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public int move() {
        if(isMove()) {
            distance++;
        }
        printDistance();
        return distance;
    }

    public void validateName(String name) {
        validateNameLength(name);
    }

    public static void validateNameLength(String name) {
        if(name.length() > NAME_MAX_LENGTH || name.length() < NAME_MIN_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }

    boolean isMove() {
        return Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE) >= IS_MOVE;
    }

    public void printDistance() {
        System.out.println(name + PRINT_DISTANCE_DELIMITER + String.join(DASH_DELIMITER, Collections.nCopies(distance, DASH)));
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
