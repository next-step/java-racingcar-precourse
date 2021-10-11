package racinggame.domain;

public class Car {
    private Name name;
    private Position position;

    public Car(Name name) {
        this.name = name;
        this.position = new Position();
    }

    public void changePosition() {
        MoveStatus status = MoveJudge.judge();
        if (status.equals(MoveStatus.MOVE)) {
            this.position.forward();
        }
    }

    public boolean isSamePosition(Position maxPosition) {
        return this.position.equals(maxPosition);
    }

    public String getName() {
        return name.getName();
    }

    public Position getPosition() {
        return position;
    }
}
