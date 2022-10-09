package racingcar;

public class Car {

    private final String CarName;
    private int Position;
    public static final int GO_FORWORD_MIN_NUMBER = 4;

    public int getPosition() {
        return Position;
    }

    public void setPosition(int position) {
        Position = position;
    }

    public Car(String carName) {

        ValidCheck.checkInputName(carName);
        this.CarName = carName;

        this.setPosition(0);

    }

    public String getCarName() {
        return CarName;
    }


    public CarCondition run(int conditionValue) {
        if (conditionValue >= GO_FORWORD_MIN_NUMBER)
            return CarCondition.Forword;
        return CarCondition.Stop;
    }

    public void goForward() {

        this.setPosition(this.getPosition() + 1);
    }
}
