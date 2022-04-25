package racingcar.domain;

public class GameRound {
    private final int round;

    public GameRound(String strOfRound) {
        this.round = toInt(strOfRound);
    }

    private int toInt(String numOfRound) {
        try {
            return Integer.parseInt(numOfRound);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    public int getRound() {
        return round;
    }
}
