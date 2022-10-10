package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.utils.StringUtil.*;

public class ScannerUtil {

    public static String readLine() {
        String stringInput = Console.readLine();
        validateNullAndEmpty(isNullOrEmpty(stringInput));
        return stringInput;
    }
}
