package utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    public static void validateNames(List<String> input) {
        if (input.size() < 2) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 2개 이상 입력해야 합니다.");
        }

        for (String name : input) {
            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 1~5글자여야 합니다.");
            }
        }

        Set<String> names = new HashSet<>(input);
        if (names.size() != input.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
        }
    }

    public static void validateAttemptNum(String input) {
        try {
            int num = Integer.parseInt(input);
            if (num < 1) {
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 0 이하가 될 수 없습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상의 자연수로 입력해야 합니다.");
        }
    }
}
