package racinggame.view;

import nextstep.utils.Console;

public class InputView {

    public static String inputNameString() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static int inputMoveCount() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException numberFormatException) {
            System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            return inputMoveCount();
        }
    }
}
