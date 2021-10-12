package racinggame.domain;

public class RacingCar {

    private final Name name;
    private Position position;

    public RacingCar(final Name name) {
        this.name = name;
        this.position = new Position();
    }

    public void move(final int value) {
        if (value < 0 || value > 9) {
            throw new IllegalArgumentException("0 이상, 9 이하의 범위를 벗어나는 값을 입력할 수 없습니다.");
        }

        if (value >= 4) {
            position = position.next();
        }
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
