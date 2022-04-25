package racingcar;

public class GameInfo {
    public static final int MIN_COUNT = 1;
    public static final int MAX_COUNT = Integer.MAX_VALUE;    // 요구사항에서 최대 게임수가 명시되지 않아 변경될 수 있음
    public static final String ERROR_MESSAGE = "[ERROR]";
    public static final String ERROR_SIZE_MESSAGE = " :" + MIN_COUNT + " ~ " + MAX_COUNT + " 범위 밖의 숫자를 입력하였습니다";

    private int rounds;

    public GameInfo(String command) {
        int tempCount = stringToInteger(command);

        validateSize(tempCount);

        this.rounds = tempCount;
    }

    private int stringToInteger(String command) {
        return Integer.parseInt(command);
    }

    private void validateSize(int rounds) {
        if (MIN_COUNT > rounds || MAX_COUNT < rounds) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_SIZE_MESSAGE);
        }
    }

    public GameStatus isPlay(int currentRounds) {
        if(currentRounds < this.rounds) return GameStatus.PLAY;

        return GameStatus.STOP;
    }
}
