package racingcar.model;

import static racingcar.constant.ErrorMessage.CAR_NAME_NOT_MORE_THAN_5;

public class Car {

    private final int NAME_MAX_LENGTH = 5;

    private String name;
    private AdvanceCount advanceCount;

    public void initCarName(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_NOT_MORE_THAN_5);
        }
        this.name = name;
    }

    public void initAdvanceCount() {
        this.advanceCount = new AdvanceCount();
    }

    public void addedAdvanceCount() {
        this.advanceCount.addedCount();
    }

    public int getNowAdvanceCount() {
        return advanceCount.getNowCount();
    }

    public String getName() {
        return name;
    }

    public String getRacingRoad() {
        return advanceCount.getRacingRoad();
    }
}
