package racingcar.utils;

import java.util.regex.Pattern;

public class Rules {

    public static void carNamingRule(String enteredNames) {
        String[] names = enteredNames.split(",");
        for (String name : names) {
            if (name.length() > 5) throw new IllegalArgumentException("[ERROR]" + "자동차 이름은 5글자를 넘을 수 없습니다.");
        }

    }

    public static void gameTryCountRule(String tryCount) {
        if (!Pattern.matches("-?\\d+", tryCount))
            throw new IllegalArgumentException("[ERROR] " + "게임횟수는 숫자만 가능합니다.");
    }
}
