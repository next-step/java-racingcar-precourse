package racingcar.feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CarName {
    private static final int MAX_LENGTH = 5;
    private static final String EMPTY_STRING = "";

    private final String name;

    public CarName(final String name) {
        this.name = name;
    }

    public static List<CarName> makeCarName(String inputNames) {
        List<String> names = makeNames(inputNames);
        validate(names);
        List<CarName> carNames = new ArrayList<>();
        names.forEach(name -> carNames.add(new CarName(name)));
        return carNames;
    }

    public String getCarName() {
        return this.name;
    }

    private static List<String> makeNames(String inputNames) {
        return Arrays.asList(inputNames.split(","));
    }

    private static void validate(List<String> names) {
        containsSpaceOrEmptyNameCheck(names);
        overFiveCharacterCheck(names);
        onlyOneCarCheck(names);
        duplicatedCarNameCheck(names);
    }

    private static void containsSpaceOrEmptyNameCheck(List<String> names) {
        names.forEach(CarName::isContainsSpaceOrEmptyName);
    }

    private static void overFiveCharacterCheck(List<String> names) {
        names.forEach(CarName::isOverFiveCharacter);
    }

    private static void onlyOneCarCheck(List<String> names) {
        if (isOnlyOne(names)) {
            throw new IllegalArgumentException("[ERROR] 최소 2대 이상의 자동차");
        }
    }

    private static void duplicatedCarNameCheck(List<String> names) {
        if (isduplicate(names)) {
            throw new IllegalArgumentException("[ERROR] 중복 된 자동차 이름");
        }
    }

    private static void isContainsSpaceOrEmptyName(String name) {
        if (isEmptyString(name)) {
            throw new IllegalArgumentException("[ERROR] 공백이 포함되지 않은 자동차 이름을 입력");
        }
    }

    private static void isOverFiveCharacter(String name) {
        if (isOverCharacter(name)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자보다 작아야 한다");
        }
    }

    private static boolean isEmptyString(String name) {
        return name.trim().equals(EMPTY_STRING);
    }

    private static boolean isOverCharacter(String name) {
        return name.length() > MAX_LENGTH;
    }

    private static boolean isOnlyOne(List<String> names) {
        return names.size() == 1;
    }

    private static boolean isduplicate(List<String> names) {
        return names.size() != new HashSet<>(names).size();
    }
}
