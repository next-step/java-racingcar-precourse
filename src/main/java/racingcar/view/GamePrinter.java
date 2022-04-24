package racingcar.view;

import java.util.List;

public class GamePrinter {
    private final static String GAME_INIT_MESSAGE = "게임을 시작합니다.";
    private final static String CAR_NAMES = "경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    private final static String GAME_ROUNDS = "시도할 회수";
    public final static String ERROR = "[ERROR]";
    public final static String CAR_NAME_EMPTY = "자동차 이름이 비어있습니다. 다시 입력해주세요";
    public final static String DUPLICATE_NAME = "동일한 이름의 자동차가 존재합니다. 다시 입력해주세요";
    public final static String FIVE_LETTER = " 이름은 다섯글자까지 입력할 수 있습니다. 다시 입력해주세요";
    private static final String ONLY_POSITIVES = " 양의 정수를 입력해주세요.";

    public static void printInitMessage() {
        System.out.println(GAME_INIT_MESSAGE);
    }

    public static void printCarNames() {
        System.out.println(CAR_NAMES);
    }

    public static void printGameRounds() {
        System.out.println(GAME_ROUNDS);
    }

    public static void printErrorValidNumber() {
        System.out.println(ERROR + ONLY_POSITIVES);
    }

    public static void printErrorValidNames() {System.out.println(ERROR + FIVE_LETTER);}

    public static void printEmptyName() {
        System.out.println(CAR_NAME_EMPTY);
    }

    public static void printDuplicateName() {
        System.out.println(DUPLICATE_NAME);
    }

    public static void printCarAndDashes(String playGame, Integer dashLine) {
        System.out.printf("%s : %s %n", playGame, getDashLines(dashLine));
    }

    public static String getDashLines(int dashLine) {
        StringBuilder dashes = new StringBuilder();
        while (dashLine > 0) {
            dashes.append("-");
            dashLine -= 1;
        }
        return dashes.toString();
    }

    public static void printWinner(List<String> winnerNominates) {
        String winners = String.join(", ", winnerNominates);
        System.out.printf("최종 우승자: %s", winners);
    }
}

