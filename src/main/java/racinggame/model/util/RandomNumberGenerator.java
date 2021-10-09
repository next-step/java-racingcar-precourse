package racinggame.model.util;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    private static final int ZERO = 0;
    private static final int NINE = 9;

    public static List<Integer> generate(int size) {
        List<Integer> list = new ArrayList<>();

        for (int i = ZERO; i < size; i++) {
            int randomNumber = Randoms.pickNumberInRange(ZERO, NINE);
            list.add(randomNumber);
        }

        return list;
    }
}
