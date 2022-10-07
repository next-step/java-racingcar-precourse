package racingcar;

import org.junit.platform.commons.util.StringUtils;

public class Car {

    String name;

    int moveCount;

    public Car(String name) {
        if (nullValidation(name) && sizeValidation(name)) {
            this.name = name;
        }
        this.moveCount = 0;
    }

    protected String getName() {
        return this.name;
    }

    protected void setMoveCount() {
        this.moveCount += 1;
    }

    protected int getMoveCount() {
        return this.moveCount;
    }

    protected void move(int num) {
        numberValidation(num);

        if (num >= Config.MOVE) {
            setMoveCount();
        }
    }

    protected String getRaceStatus() {
        StringBuilder status = new StringBuilder();
        for (int i = 0; i < moveCount; i++) {
            status.append(Config.MOVE_DISPLAY);
        }
        return status.toString();
    }

    private void numberValidation(int number) {
        if (number < Config.START_NUM || number > Config.END_NUM) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_MOVE_COUNT.getMessage());
        }
    }

    private boolean sizeValidation(String name) {
        if (name.length() > Config.MAX_NAME_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_MAX_SIZE.getMessage());
        }
        return true;
    }

    private boolean nullValidation(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(ExceptionMessage.CAR_NAME_MAX_SIZE.getMessage());
        }
        return true;
    }

}