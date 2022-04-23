package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameMissionUtilsScanner implements GameScanner {

    @Override
    public List<String> scanCarNames() {
        String input = Console.readLine();
        try {
            validateNotNull(input);
            validateNotEmpty(input);
            return splitCarName(input);
        } catch (Exception e) {
            System.out.printf("[ERROR] %s%n", e.getMessage());
            return scanCarNames();
        }
    }

    @Override
    public Integer scanCount() {
        String input = Console.readLine();
        try {
            validateNotNull(input);
            validateNotEmpty(input);
            validateIsNumberFormat(input);
            return Integer.valueOf(input);
        } catch (NumberFormatException e) {
            System.out.printf("[ERROR] %s%n", e.getMessage());
            return scanCount();
        }
    }

    void validateNotNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException("input 값이 null 입니다.");
        }
    }

    void validateNotEmpty(String input) {
        validateNotNull(input);
        if (input.isEmpty()) {
            throw new IllegalArgumentException("input 값이 empty 입니다.");
        }
    }

    void validateIsNumberFormat(String input) {
        validateNotEmpty(input);
        try {
            Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("시도 횟수는 숫자여야 한다. (invalidValue:%s)", input));
        }
    }

    List<String> splitCarName(String input) {
        List<String> carNameList = new ArrayList<>();
        for (String carNameCandidate : input.split(",")) {
            String carName = carNameCandidate.trim();
            validateCarNameLength(carName);
            addIfNotEmpty(carNameList, carName);
        }
        return carNameList;
    }

    void validateCarNameLength(String carName) {
        validateNotNull(carName);
        if (carName.length() >= 6) {
            throw new IllegalArgumentException(String.format("Car 이름은 5자 이하만 가능합니다. invalidValue:%s", carName));
        }
    }

    void addIfNotEmpty(List<String> carNameList, String carName) {
        validateNotNull(carName);
        if (!carName.isEmpty()) {
            carNameList.add(carName);
        }
    }
}
