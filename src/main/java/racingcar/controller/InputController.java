package racingcar.controller;

import racingcar.view.Input;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputController {

    public static List<String> setRacers() {
        String nameString;
        List<String> names;
        try {
            nameString = Input.carNameInput();
            names = Arrays.asList(nameString.split(","));

            // validations
            isRightNamesString(nameString);
            isRightNameSize(names);
            isNotDuplicate(names);

            return names;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setRacers();
        }
    }

    public static int setNumberOfRound() {
        String numberOfRound;

        try {
            numberOfRound = Input.roundNumberInput();
            // TODO: Round Number Validation 추가
            return Integer.parseInt(numberOfRound);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setNumberOfRound();
        }
    }

    public static void isRightNamesString(String nameString) {
        if (!Pattern.compile("^[가-힣\\w]+[가-힣\\w" + "," + "]*[가-힣\\w]$").matcher(nameString).matches()) {
            throw new IllegalArgumentException("[ERROR] 자동차 목록은 쉼표로 구분된 비어있지 않은 문자여야 한다.");
        }
    }

    public static void isRightNameSize(List<String> names) {
        if (names.stream().anyMatch(name -> name.isEmpty() || name.length() > 5)) {
            throw new IllegalArgumentException("[ERROR] 자동차 목록은 1자~5자의 문자로 구성되어야 한다.");
        }
    }

    public static void isNotDuplicate(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 자동차 목록은 중복이 없어야 한다.");
        }
    }

}
