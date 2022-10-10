package racingcar.rule;

import static camp.nextstep.edu.missionutils.Randoms.*;
import static racingcar.rule.GoStop.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoStopRule {
    public static final int VALID_MIN_VALUE = 0;
    public static final int VALID_MAX_VALUE = 9;
    public static final List<Integer> GO_VALUES = Arrays.asList(4, 5, 6, 7, 8, 9);
    public static final List<Integer> STOP_VALUES = Arrays.asList(0, 1, 2, 3);

    private List<GoStop> goStops;

    public GoStopRule(int size) {
        goStops = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int randomNumber = pickNumberInRange(VALID_MIN_VALUE, VALID_MAX_VALUE);
            determineGoStop(i, randomNumber);
        }
    }

    public void determineGoStop(int index, int randomNumber) {
        if (GO_VALUES.contains(randomNumber)) {
            goStops.add(index, GO);
            return;
        }
        if (STOP_VALUES.contains(randomNumber)) {
            goStops.add(index, STOP);
            return;
        }
        throw new IllegalStateException();
    }

    public GoStop get(int i) {
        return goStops.get(i);
    }
}
