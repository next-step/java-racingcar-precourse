package nextstep.domain;

import nextstep.dto.MoveResult;

public class Car {

    private static final int MIN_MOVABLE_VALUE = 4;

    private final CarName name;
    private final Distance distance;

    public Car(String name) {
        this.name = new CarName(name);
        this.distance = Distance.zero();
    }

    public MoveResult move(int number) {
        if (number >= MIN_MOVABLE_VALUE) {
            distance.increase();;
        }
        return new MoveResult(name.getName(), distance.getDistance());
    }

    public String getName() {
        return name.getName();
    }

    public int getGreaterDistance(int distance) {
        return this.distance.getGreaterDistance(distance);
    }

    public StringBuilder appendName(StringBuilder sb, int maxDistance) {
        if (this.distance.isEqual(maxDistance)) {
            return name.appendName(sb);
        }
        return sb;
    }
}
