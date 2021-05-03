package racingcargame.view;

import java.util.Scanner;

public class ConsoleInput {

    public static final String MESSAGE_INPUT_CARNAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String MESSAGE_INPUT_MOVE_COUNT = "시도할 회수는 몇회인가요?";

    public static String inputRacingCarNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(MESSAGE_INPUT_CARNAMES);
        return scanner.nextLine();
    }

    public static Integer inputMoveCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(MESSAGE_INPUT_MOVE_COUNT);
        return scanner.nextInt();
    }
}
