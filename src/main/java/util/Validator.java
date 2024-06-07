package util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private static final int MAX_NAME_LENGTH = 5;

    /**
     * 이름이 5자 이하인지 검사합니다.
     */
    private static void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    /**
     * 이름이 공백이있거나 비어있는지 검사합니다.
     */
    private static void validateNameEmpty(String name) {
        if (name == null || name.contains(" ")) {
            throw new IllegalArgumentException("이름에 공백이 포함될 수 없습니다.");
        }
    }

    /**
     * 주어진 이름에 공백이 없는지 검사합니다.
     */
    public static void validateName(String name) {
        validateNameLength(name);
        validateNameEmpty(name);
    }

    /**
     * 중복된 이름이 있는지 검사합니다.
     */
    public static void validateDuplicateName(List<String> names) {
        Set<String> nameSet = new HashSet<>();
        for (String name : names) {
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException("중복된 이름이 있습니다.");
            }
        }
    }

    /**
     * 레이싱 횟수가 0보다 작거나 같은지 검사합니다.
     *
     * @param racingCount 레이싱 횟수
     */
    public static void validateRacingCount(int racingCount) {
        if (racingCount <= 0) {
            throw new IllegalArgumentException("레이싱 횟수는 0보다 커야합니다.");
        }
    }

    /**
     * 숫자로만 이루어져 있는지 검사합니다.
     */
    public static void validateNumber(String round) {
        if (!round.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("숫자로만 이루어져 있어야 합니다.");
        }
    }
}
