package utils;

import exceptions.CarCountLessThenTwoException;
import exceptions.CarNameLengthException;
import exceptions.DuplicatedCarNameException;
import java.util.List;

/**
 * 입력값을 검증하는 클래스
 */
public class InputValidator {

    private static final int MAX_NAME_LENGTH = 5;

    /**
     * 자동차 이름들을 검증하는 메서드
     *
     * @param names 자동차 이름 리스트
     * @throws IllegalAccessError 자동차 이름이 유효하지 않을 때 발생
     */
    public static void validateCarNames(List<String> names) throws IllegalAccessError {
        validateCarName(names);
        validateCarCount(names);
        validateDuplicateCarName(names);
    }

    private static void validateCarName(List<String> names) {
        for (String name : names) {
            if (!(name.length() <= MAX_NAME_LENGTH) || name.isBlank()) {
                throw new CarNameLengthException();
            }
        }
    }

    private static void validateCarCount(List<String> names) {
        if (names.size() < 2) {
            throw new CarCountLessThenTwoException();
        }
    }

    private static void validateDuplicateCarName(List<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new DuplicatedCarNameException();
        }
    }
}
