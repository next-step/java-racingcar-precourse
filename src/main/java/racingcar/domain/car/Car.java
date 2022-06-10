package racingcar.domain.car;

import racingcar.domain.name.Name;

public class Car {

    public static final int MIN_POSITION = 0;
    public static final int MOVE_FORWARD = 1;

    /* 이름 */
    private final Name name;

    /* 위치 */
    private final Position position;

    public Car(Name name) {
        this(name, new Position(MIN_POSITION));
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car move() {
        final Move move = new Move();
        final int randomNumber = move.getRandomNumber();
        if (move.canMove(randomNumber)) {
            int newPosition = this.position.getPosition() + MOVE_FORWARD;
            return new Car(this.name, new Position(newPosition));
        }
        return new Car(this.name, this.position);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public int updateMaxPosition(int comparePosition) {
        return position.getMaxPosition(comparePosition);
    }

    public boolean isMaxPosition(int maxPosition) {
        return position.isMaxPosition(maxPosition);
    }

}
