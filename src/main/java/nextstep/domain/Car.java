package nextstep.domain;

public class Car {

    private static final int DEFAULT_DISTANCE = 0;
    private static final int MIN_MOVABLE_VALUE = 4;

    private final CarName name;
    private int distance;

    public Car(String name) {
        this.name = new CarName(name);
        this.distance = DEFAULT_DISTANCE;
    }

    public MoveResult move(int number) {
        if (number >= MIN_MOVABLE_VALUE) {
            this.distance++;
        }
        return new MoveResult(name.getName(), this.distance);
    }

    public String getName() {
        return name.getName();
    }

    public int getMaxDistance(int distance) {
        if (distance <= this.distance) {
            return this.distance;
        }
        return distance;
    }

    public StringBuilder appendName(StringBuilder sb, int maxDistance) {
        if (distance == maxDistance) {
            return sb.append(name.getName()).append(",");
        }
        return sb;
    }
}
