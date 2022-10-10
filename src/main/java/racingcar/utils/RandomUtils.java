package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.GameConfig.*;

public class RandomUtils {

    private RandomUtils() {

    }

    public static List<Integer> randomNumbers(final int size) {
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            randomNumbers.add(randomNumber());
        }

        return randomNumbers;
    }

    private static int randomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
