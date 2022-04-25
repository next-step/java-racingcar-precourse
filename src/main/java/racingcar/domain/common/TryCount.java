package racingcar.domain.common;

import java.util.Objects;

public class TryCount {

    private final static int NUMBER_BOUNDARY = 1;
    public static final String REGEX = "[0-9]+";

    private final int tryCount;

    public TryCount(int tryCount) {
        if (NUMBER_BOUNDARY > tryCount) {
            throw new IllegalArgumentException("반복 횟수는 "+ NUMBER_BOUNDARY +"이상 입력해 주세요");
        }
        this.tryCount = tryCount;
    }

    public static TryCount of(int repeatCount) {
        return new TryCount(repeatCount);
    }

    public static TryCount of(String repeateCount) {
        if (!String.valueOf(repeateCount).matches(REGEX)) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력하세요.");
        }
        return TryCount.of(Integer.parseInt(Objects.requireNonNull(repeateCount)));
    }

    public int getTryCount(){
        return this.tryCount;
    }
}
