package racing.model;

import racing.model.strategy.RandomMoving;

public class Car {

    private Name name;
    private Record record;
    private static final String INVALID_RANDOM_MOVING_STRATEGY = "자동차 (랜덤)이동 범위를 설정하십시오.";

    public Car() {
        this.record = new Record();
    }

    public Car(final String name) {
        this.name = new Name(name);
        this.record = new Record();
    }

    public void move(RandomMoving randomMoving) {
        if (randomMoving == null) {
            throw new IllegalArgumentException(INVALID_RANDOM_MOVING_STRATEGY);
        }

        int movingRange = randomMoving.range();

        if (randomMoving.isForward(movingRange)) {
            record.update();
        }
    }

    public String getName() {
        return name.getName();
    }

    public String getRecord() {
        return record.getValue();
    }

    public Integer getRecordResult() {
        return record.getSize();
    }

}
