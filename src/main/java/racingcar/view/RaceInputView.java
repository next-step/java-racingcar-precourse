package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class RaceInputView {
    private final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)";
    private final String TRY_INPUT_MESSAGE = "시도할 회수는?";
    private final String NAME_INPUT_ERROR_MESSAGE = "[ERROR] 이름이 5자 이상인 차량이 존재합니다.";
    private final String TRY_INPUT_ERROR_MESSAGE = "[ERROR] 시도 횟수는 숫자여야 합니다.";
    private final int NAME_MAX_LENGTH = 5;

    /**
     * 차량 이름 입력
     */
    public String[] readCarNames() {
        System.out.printf("%s ", NAME_INPUT_MESSAGE);
        String s = Console.readLine();
        String[] names = s.split(",");
        validateName(names);

        return names;
    }

    /**
     * 이동 시도 횟수 입력
     */
    public Integer readTryNumber() {
        System.out.printf("%s ", TRY_INPUT_MESSAGE);
        String n = Console.readLine();
        validateTryNumber(n);

        return Integer.parseInt(n);
    }

    /**
     * 차량 이름 유효성 검증
     */
    private void validateName(String[] names) {
        for (String name : names) {
            if (name.length() > NAME_MAX_LENGTH) {
                throw new NoSuchElementException(NAME_INPUT_ERROR_MESSAGE);
            }
        }
    }

    /**
     * 이동 시도 횟수 유효성 검증
     */
    private void validateTryNumber(String s) {
        boolean isNumeric = s.chars().allMatch(Character::isDigit);
        if (!isNumeric) {
            throw new NoSuchElementException(TRY_INPUT_ERROR_MESSAGE);
        }
    }
}
