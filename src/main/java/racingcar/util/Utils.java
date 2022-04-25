package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Utils {

    private Utils() {
    }

    public static int getRandom(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }

    public static String getInput(String printValue) {
        System.out.println(printValue);
        return Console.readLine();
    }

    public static String[] splitStr(String str, String div) {
        return str.split(div);
    }

    public static int stringToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 한다.");
        }
    }
}


