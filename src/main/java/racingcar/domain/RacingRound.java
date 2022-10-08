package racingcar.domain;

public class RacingRound {
    private final Integer round;

    private RacingRound(Integer round) {
        this.round = round;
    }

    public static RacingRound of(String round) {
        validateOffsetFormat(round);
        validateStarsWithZero(round);
        return new RacingRound(Integer.parseInt(round));
    }

    public Integer getRound() {
        return round;
    }

    private static void validateOffsetFormat(String offset) {
        if (!offset.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 시도 회수는 양의 정수로 입력하셔야 합니다");
        }
    }

    private static void validateStarsWithZero(String offset) {
        if (offset.startsWith("0")) {
            throw new IllegalArgumentException("[ERROR] 시도 회수는 0이거나 0으로 시작할 수 없습니다");
        }
    }
}
