package racingcar.domain;

public class Car {
    private final CarName name;
    private int position = 0;

    public Car(String name) {
        this.name = new CarName(name);
    }

    public void move(MoveStatus status) {
        if (status.isMove()) {
            this.position++;
        }
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position;
    }
}