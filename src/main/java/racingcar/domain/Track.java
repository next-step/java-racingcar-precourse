package racingcar.domain;

public class Track {

    private final int count;

    public Track(int count) {
        validationCount(count);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    private void validationCount(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("레이싱 트랙 값이 유효하지 않습니다.");
        }
    }

    public static Track of(int count) {
        return new Track(count);
    }
}
