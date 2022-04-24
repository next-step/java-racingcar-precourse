package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class CommonUtils {
    public static boolean isNullOrEmptyString(String str) {
        return str == null || str == "";
    }

    public static String inputText() {
        return Console.readLine();
    }

    public static int getRandomNumber(int startNumber, int endNumber) {
        return Randoms.pickNumberInRange(startNumber, endNumber);
    }

    public static boolean isGreaterThanNumber(int number1, int number2) {
        return number1 > number2;
    }
}
