package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class CommonUtil {
    public static String inputText() {
        return Console.readLine();
    }

    public static int getRandomNumber(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }

    public static boolean isNullOrEmptyCheck(String str) {
        return str == null || str == "";
    }
}
