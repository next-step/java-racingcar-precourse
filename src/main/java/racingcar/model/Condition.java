package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Require;

import java.util.ArrayList;
import java.util.List;

public class Condition {
    private static int createCondition() {
        return Randoms.pickNumberInRange(Require.MIN_VALUE.getValue(), Require.MAX_VALUE.getValue());
    }

    public static List<Integer> createConditions(int countOfCars) {
        List<Integer> conditions = new ArrayList<>();
        for (int i = Require.MIN_VALUE.getValue(); i < countOfCars ; i++) {
            conditions.add(createCondition());
        }

        return conditions;
    }

    public static CarStatus getStatus(int condition) {
        if (condition < Require.MORE_THAN_CONDITION.getValue()) {
            return CarStatus.STOP;
        }

        return CarStatus.GO;
    }

}
