package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class ConditionGenerator {

    private static final int MIN = 0;
    private static final int MAX = 9;

    public static MovingConditions generate(Lineup lineup) {
        MovingConditions conditions = new MovingConditions();
        for (int i = 0; i < lineup.numberOfCars(); i++) {
            int numOfCond = Randoms.pickNumberInRange(MIN, MAX);
            conditions.match(lineup.getAt(i), new MovingCondition(numOfCond));
        }

        return conditions;
    }
}
