package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class RaceInputView {
    private final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)";
    private final String TRY_INPUT_MESSAGE = "시도할 회수는?";
    private final String NAME_INPUT_ERROR_MESSAGE = "[ERROR]이름이 5자 이상인 차량이 존재합니다.";
    private final String TRY_INPUT_ERROR_MESSAGE = "[ERROR]시도 횟수는 숫자여야 합니다.";
    private final int NAME_MAX_LENGTH = 5;

    /**
     * 차량 이름 입력
     */
    public String[] readCarNames() {
        String[] names;

        do {
            System.out.printf("%s\n", NAME_INPUT_MESSAGE);
            names = Console.readLine().split(",");
        } while(!validateLength(names));

        return names;
    }

    /**
     * 이동 시도 횟수 입력
     */
    public Integer readTryNumber() {
        String n;
        do {
            System.out.printf("%s\n", TRY_INPUT_MESSAGE);
            n = Console.readLine();
        } while(!validateIsDigit(n));

        return Integer.parseInt(n);
    }

    /**
     * 차량 이름 유효성 검증
     */
    private boolean validateLength(String[] names) {
        try {
            for (String name : names) {
                if (name.length() > NAME_MAX_LENGTH)
                    throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException ie){
            System.out.println(NAME_INPUT_ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     * 이동 시도 횟수 유효성 검증
     */
    private boolean validateIsDigit(String s) {
        try{
            boolean isNumeric = s.chars().allMatch(Character::isDigit);
            if (!isNumeric)
                throw new NoSuchElementException();
        } catch(IllegalArgumentException ie){
            System.out.println(TRY_INPUT_ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
