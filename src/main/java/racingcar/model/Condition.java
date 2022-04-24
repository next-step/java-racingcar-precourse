package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.message.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Condition {
    private static final int MIN_VALUE = 0;
    private static final int CONDITION = 4;
    private static final int MAX_VALUE = 9;

    private static int condition;

    private Condition() {
    }

    private static int createCondition() {
        try {
            condition = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
            validate(condition);
        } catch (IllegalArgumentException e) {
            // print
            createCondition();
        }
        return condition;
    }

    public static List<Integer> createConditions(int countOfCars) {
        List<Integer> conditions = new ArrayList<>();
        for (int i = MIN_VALUE; i < countOfCars; i++) {
            conditions.add(createCondition());
        }

        return conditions;
    }

    public static CarStatus getStatus(int condition) {
        if (condition < CONDITION) {
            return CarStatus.STOP;
        }

        return CarStatus.GO;
    }

    public static void validate(int condition) {
        if (condition > MAX_VALUE || condition < MIN_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_CONDITION_ERROR.getMessage());
        }
    }

    public static int getMaxValue() {
        return MAX_VALUE;
    }

    public static int getMinValue() {
        return MIN_VALUE;
    }
}
