package racingcar.utils;

import org.junit.jupiter.params.ParameterizedTest;
import racingcar.config.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private static InputValidator inputHandler;
    private static int MAX_LENGTH = 5;
    private static int EMPTY_LENGTH = 0;
    private static int LEAST_CANDIDATE_NUMBER = 2;
    private static int ZERO = 0;
    private static String SPACE = " ";
    private static String SPLIT_TARGET = ",";

    private InputValidator() {} // 싱글톤 구현

    public synchronized static InputValidator getInstance() {
        if (inputHandler == null)
            inputHandler = new InputValidator();
        return inputHandler;
    }

    public void validateEmpty(String input) {
        if (input.length() <= EMPTY_LENGTH)
            throw new IllegalArgumentException(ErrorMessage.EmptyValue.toString());
    }

    public void validateSplitWord(String input) {
        if (input.contains(SPACE))
            throw new IllegalArgumentException(ErrorMessage.SplitChar.toString());
    }


    public void validateLeastCandidate(String input) {
        if (input.split(SPLIT_TARGET).length < LEAST_CANDIDATE_NUMBER)
            throw new IllegalArgumentException(ErrorMessage.LeastCandidate.toString());
    }

    public void validateSameName(String input) {
        String[] users = input.split(SPLIT_TARGET);
        for (int i = 0; i < users.length; i++)
            doubleCheck(i, users);
    }

    private void doubleCheck(int index, String[] users) {
        for (int i = 0; i < users.length; i++) {
            if (index == i) continue;
            compare(users[index], users[i]);
        }
    }

    private void compare(String name_1, String name_2) {
        if (name_1.equals(name_2))
            throw new IllegalArgumentException(ErrorMessage.SameName.toString());
    }

    public void validateEmptyName(String name) {
        if (name.length() <= EMPTY_LENGTH)
            throw new IllegalArgumentException(ErrorMessage.EmptyName.toString());
    }

    public void validateNameLimit(String name) {
        if (name.length() > MAX_LENGTH)
            throw new IllegalArgumentException(ErrorMessage.ExceedCount.toString());
    }

    public void validateNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.NotNumber.toString());
        }
    }

    public void validateNumberRange(String number) {
        try {
            int num = Integer.parseInt(number);
            validateNotPlus(num);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.ExceedNumber.toString());
        }
    }

    private void validateNotPlus(int number) {
        if (number <= ZERO) {
            throw new IllegalArgumentException(ErrorMessage.ExceedNumber.toString());
        }
    }
}
