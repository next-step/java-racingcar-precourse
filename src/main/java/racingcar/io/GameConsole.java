package racingcar.io;

public class GameConsole {
    public static final String GREETING_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String RETRY_STRING = "";
    public static final Integer RETRY_INTEGER = Integer.MIN_VALUE;

    private final InputReader reader = new InputReader();

    private GameConsole() {
    }

    public static GameConsole create() {
        return new GameConsole();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printResultMessage(String message) {
        System.out.println("최종 우승자: " + message);
    }

    public String queryCarNames() {
        String input;
        do {
            System.out.println(GREETING_MESSAGE);
            input = readLineWithHandleException();
        } while (RETRY_STRING.equals(input));
        return input;
    }

    public int queryRound() {
        int round;
        do {
            System.out.println("시도할 회수는 몇회인가요?\n");
            round = readNumberWithHandleException();
        } while (round == RETRY_INTEGER);
        return round;
    }

    private String readLineWithHandleException() {
        try {
            return reader.readStringWithCommas();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return RETRY_STRING;
        }
    }

    private int readNumberWithHandleException() {
        try {
            return reader.readNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return RETRY_INTEGER;
        }
    }
}
