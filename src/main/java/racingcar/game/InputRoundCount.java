package racingcar.game;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class InputRoundCount {
    private static final String NUMBER_CHECK_PATTERN = "\\D";
    private int roundNumber;


    private InputRoundCount(final int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public static InputRoundCount valueOf(final String roundCountString) {
        validateRoundCountString(roundCountString);
        return new InputRoundCount(parseInt(roundCountString));
    }

    public <T> List<T> mapTimes(final Supplier<T> supplier) {
        List<T> tList = new ArrayList<>();

        for (int i = 0; i < roundNumber; i++) {
            tList.add(supplier.get());
        }

        return tList;
    }

    public int getRoundCount() {
        return this.roundNumber;
    }

    private static void validateRoundCountString(final String roundCountString) {
        if (roundCountString.length() == 0) {
            throw new IllegalArgumentException("[ERROR] 시도 회수를 입력해주세요.");
        }

        if (roundCountString.matches(NUMBER_CHECK_PATTERN)) {
            throw new IllegalArgumentException("[ERROR] 시도 회수는 숫자로 입력해주세요.");
        }

        if (parseInt(roundCountString) <= 0) {
            throw new IllegalArgumentException("[ERROR] 시도할 회수가 0 보다 작을 수 없습니다.");
        }
    }
}
