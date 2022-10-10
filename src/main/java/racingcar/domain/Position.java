package racingcar.domain;

import racingcar.constant.ErrorMessage;

public class Position {

    public static final int POSITION_MIN = 0;

    private int position;

    public Position() {
    }

    public Position(String position) {

        if (!validNullPosition(position)) {
            throw new IllegalArgumentException(ErrorMessage.POSITION_NULL_ERROR.getMessage());
        }
        if (!validNumberPosition(position)) {
            throw new IllegalArgumentException(ErrorMessage.POSITION_NUMBER_FORMAT_VALID_ERROR.getMessage());
        }


    }


    private boolean validNullPosition(String position) {
        return position != null;
    }

    private boolean validNumberPosition(String position) {
        try {
            this.position = Integer.parseInt(position);
            if (this.position >= POSITION_MIN) {
                return true;
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.POSITION_NUMBER_FORMAT_VALID_ERROR.getMessage());
        }

        return false;
    }

    public int getPosition() {
        return position;
    }

    public int addPosition() {
        return this.position++;
    }


}
