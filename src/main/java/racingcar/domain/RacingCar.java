package racingcar.domain;

import racingcar.util.Assert;

import java.util.Objects;

public class RacingCar implements Comparable<RacingCar> {

    private final RacingCarName name;
    private final RacingCarPosition position;

    public RacingCar(final RacingCarName name, final RacingCarPosition position) {
        Assert.notNull(name, "name은 필수 값입니다.");
        Assert.notNull(position, "position은 필수 값입니다.");

        this.name = name;
        this.position = position;
    }

    public RacingCar(final String name) {
        this(new RacingCarName(name), RacingCarPosition.startingLine());
    }

    public void move(final MoveCondition moveCondition) {
        Assert.notNull(moveCondition, "moveCondition은 필수 값입니다.");

        if (moveCondition.isSatisfied()) {
            position.move();
        }
    }

    public boolean isAtSamePosition(final RacingCar other) {
        return Objects.equals(this.position, other.position);
    }

    @Override
    public int compareTo(final RacingCar other) {
        return Objects.compare(this.position, other.position, RacingCarPosition::compareTo);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
