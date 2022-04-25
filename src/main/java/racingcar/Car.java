package racingcar;

public class Car {
    private CarName name;
    private CarPosition position;

    private Car(String name) {
        this.name = new CarName(name);
        this.position = new CarPosition();
    }

    public static Car create(String name) {
        return new Car(name);
    }

    public void canMoveForward(int no) {
        if(isBiggerThanStandard(no)) {
            moveForward();
        }
    }

    public void moveForward() {
        position.increaseCurPosition();
    }

    private boolean isBiggerThanStandard(int no) {
        return no >= CarProperties.LEAST_NUM_TO_MOVE;
    }

    public int getPosition() {
        return position.getCurPosition();
    }

    public String getName() {
        return name.getName();
    }
}
