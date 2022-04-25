package racingcar.domain;

public class PlayCount {
    private final int playCount;

    public PlayCount(String input) {
        assert(input != null);
        try {
            this.playCount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 한다.");
        }
    }

    public int getPlayCount() {
        return playCount;
    }
}
