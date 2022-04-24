package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class CustomUtils {

    public static String[] stringSplitByComma(String input) {
        String[] strArr = input.split(",");

        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = strArr[i].trim();
        }

        return strArr;
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
