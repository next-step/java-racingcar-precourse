package racinggame.view;

import nextstep.utils.Console;

public class ConsoleInputView {

    private static final String NAME_INPUT_SUMMARY = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPTS_INPUT_SUMMARY = "시도할 회수는 몇회인가요?";
    private static final String ATTEMPTS_PARSE_ERROR_MESSAGE = "시도 회수는 숫자만 입력 할 수 있습니다.";

    public String enterNames() {
        System.out.println(NAME_INPUT_SUMMARY);
        return Console.readLine();
    }

    public int enterAttempts() {
        try {
            System.out.println(ATTEMPTS_INPUT_SUMMARY);
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ATTEMPTS_PARSE_ERROR_MESSAGE);
        }
    }
}
