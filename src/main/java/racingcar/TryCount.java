package racingcar;

import java.text.ParseException;

public class TryCount {

    int tryCount;

    public TryCount() {

    }

    public TryCount(String s) {
        isInputIsInteger(s);

        this.tryCount = Integer.parseInt(s);
    }

    public void isInputIsInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
    }
}
