package racinggame.utils;

import java.util.*;

public class StringUtils {
    private static final String SEPERATOR = ",";
    private static final String EMPTY = "";
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    public static List<String> inputStringSeparator(String inputString) {
        validateInputString(inputString);
        String[] nameArray = inputString.split(SEPERATOR);
        Set<String> nameSet = new LinkedHashSet<>();
        for (String name : nameArray) {
            validateNameLength(name);
            nameSet.add(name);
        }
        validateDupleName(nameSet, nameArray.length);
        return new LinkedList<>(nameSet);
    }

    private static void validateInputString(String inputString) {
        if (inputString == null || inputString.equals(EMPTY)) {
            throw new IllegalArgumentException("[ERROR] null 또는 빈값을 입력하면 안됩니다.");
        }
    }

    private static void validateDupleName(Set<String> nameSet, int namesSize) {
        if (nameSet.size() != namesSize) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름을 입력하면 안됩니다,");
        }
    }

    private static void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 차 이름은 5자 이하만 가능합니다.");
        }
    }
}
