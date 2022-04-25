package racingcar.domain;

import racingcar.exception.domain.CarPositionException;

public class CarPosition {
    private static final String PRINT_POSITION_WORD = "-";
    private static final int MIN_POSITION = 0;

    private int position;

    public CarPosition(Integer position) {
        validate(position);
        this.position = position;
    }

    private void validate(Integer position) {
        if (position < MIN_POSITION) {
            throw new CarPositionException();
        }
    }

    public void addPosition() {
        position++;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int index = MIN_POSITION; index < position; index++) {
            sb.append(PRINT_POSITION_WORD);
        }

        return sb.toString();
    }

    public int getPosition() {
        return position;
    }
}
