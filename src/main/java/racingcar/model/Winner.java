package racingcar.model;

import java.util.List;

public class Winner {

    public static final String INVALID_SIZE = "우승자 미입력 에러";

    private List<String> names;

    public Winner(List<String> names) {
        this.names = names;
        validateWinnerSize();
    }

    private void validateWinnerSize() {
        if (this.names.size() < 1) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
    }

    public boolean isSolo() {
        return names.size() == 1;
    }

    public int size() {
        return names.size();
    }

    public String get(int i) {
        return names.get(i);
    }
}
