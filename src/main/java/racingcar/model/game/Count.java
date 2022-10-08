package racingcar.model.game;

import racingcar.exception.MessageMaker;

import java.util.regex.Pattern;

public class Count {

    private static final String NULL_COUNT = "횟수가 존재하지 않습니다";
    private static final String NOT_ALLOW_CHARACTER = "횟수는 0보다큰 수만 허용합니다";
    private static final int NOT_ALLOW_NUMBER = 0;
    private final int tryCount;
    private int remainCount;

    public Count(String count) {
        validateNumber(count);
        this.tryCount = Integer.parseInt(count);
        this.remainCount = tryCount;
    }


    private void validateNumber(String count) {
        if (count == null) throw new NullPointerException(MessageMaker.getMessage(NULL_COUNT));

        if (!Pattern.matches("^[0-9]+$", count)) {
            throw new IllegalArgumentException(MessageMaker.getMessage(NOT_ALLOW_CHARACTER));
        }
        if (Integer.parseInt(count) == NOT_ALLOW_NUMBER)
            throw new IllegalArgumentException(MessageMaker.getMessage(NOT_ALLOW_CHARACTER));
    }


    public boolean next() {
        if (remainCount == NOT_ALLOW_NUMBER) return false;
        remainCount--;
        return true;
    }

    public boolean hasNext() {
        return remainCount > 0;
    }

    public int getTryCount() {
        return tryCount;
    }


}
