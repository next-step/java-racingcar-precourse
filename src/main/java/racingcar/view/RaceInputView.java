package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class RaceInputView {
    private final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분";
    private final String TRY_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    /**
     * 차량 이름 입력
     */
    public String[] readCarNames() {
        System.out.println(NAME_INPUT_MESSAGE);
        String s = Console.readLine();
        String[] names = s.split(",");
        validateName(names);

        return names;
    }

    /**
     * 이동 시도 횟수 입력
     */
    public Integer readTryNumber() {
        System.out.println(TRY_INPUT_MESSAGE);
        String n = Console.readLine();
        validateTryNumber(n);

        return Integer.parseInt(n);
    }

    /**
     * 차량 이름 유효성 검증
     */
    private void validateName(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * 이동 시도 횟수 유효성 검증
     */
    private void validateTryNumber(String s) {
        boolean isNumeric = s.chars().allMatch(Character::isDigit);
        if (!isNumeric) {
            throw new IllegalArgumentException();
        }
    }
}
