package racingcar.domain;

public class CarPosition {

    private int position;

    int getPosition() {
        return position;
    }

    public void control(ControlType controlType) {
        position += controlType.getDistance();
    }
}
