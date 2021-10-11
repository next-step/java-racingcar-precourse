package racinggame;

import nextstep.utils.Console;
import racinggame.utils.StringUtil;

import java.util.StringTokenizer;

public class RacingGameView {

    public String viewCarName() {
        printInputCarsName();

        return inputCarsName();
    }

    private void printInputCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private String inputCarsName() {
        String input;

        do {
            input = Console.readLine();
        } while (!isValidCarName(input));
        return input;
    }

    private boolean isValidCarName(String input) {
        try {
            checkHasText(input);
            checkCarsName(input);
        } catch (Exception e) {
            System.out.println("[ERROR] : " + e.getMessage());
            return false;
        }
        return true;
    }

    private void checkCarsName(String input) {
        StringTokenizer st = new StringTokenizer(input, ",");
        while (st.hasMoreTokens()) {
            checkNameLength(st.nextToken());
        }
    }

    private void checkNameLength(String name) {
        if (name.trim().length() > 5) {
            throw new IllegalArgumentException("이름은 5자를 넘을 수 없습니다.");
        }
    }

    public int viewRoundCount() {
        printRoundCount();

        return inputRoundCount();
    }

    private void printRoundCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private int inputRoundCount() {
        String input;

        do {
            input = Console.readLine();
        } while (!isValidRoundCount(input));

        return Integer.parseInt(input);
    }

    private boolean isValidRoundCount(String input) {
        try {
            checkHasText(input);
            checkNumeric(input);
            checkPositiveNumber(input);
        } catch (Exception e) {
            System.out.println("[ERROR] : " + e.getMessage());
            return false;
        }
        return true;
    }

    private void checkPositiveNumber(String input) {
        int num = Integer.parseInt(input);
        if (num < 0) {
            throw new IllegalArgumentException("횟수는 음수가 될 수 없습니다.");
        }
    }

    private void checkHasText(String input) {
        if (!StringUtil.hasText(input)) {
            throw new IllegalArgumentException("입력값을 제대로 입력해주세요.");
        }
    }

    private void checkNumeric(String input) {
        if (!StringUtil.isNumeric(input)) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
}
