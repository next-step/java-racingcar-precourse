package racinggame.domain;

import nextstep.utils.Randoms;

public class Car {
    private static final int MIN_BOUND = 1;
    private static final int MAX_BOUND = 9;
    private static final int MOVING_FORWARD = 4;        // 4 이상 전진 / 3이하 정지

    private final Name name;
    private Position position = new Position();

    public Car(final Name name) {
        this.name = name;
    }

    public Car(final Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name.getName();
    }

    public Position getPosition() {
        return position;
    }

    public void move(MovableStrategy movableStrategy) {
        if (movableStrategy.movable())
            this.position = this.position.move();
    }

    public void move() {
        if (getRandomNo() >= MOVING_FORWARD)
            this.position = this.position.move();
    }

    protected int getRandomNo() {
        return Randoms.pickNumberInRange(MIN_BOUND, MAX_BOUND);
    }
}
