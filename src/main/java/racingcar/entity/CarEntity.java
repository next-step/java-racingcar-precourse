package racingcar.entity;

public class CarEntity {

    private CarName carName;
    private CarPosition carPosition;

    public CarEntity(String name) {
        carName = new CarName(name);
        carPosition = new CarPosition(0);
    }

    public void setPosition(int position) {
        carPosition.setPosition(position);
    }

    public int getPosition() {
        return carPosition.getPosition();
    }

    public String getName() {
        return carName.getName();
    }

    public boolean moveCar(int n) {
        carPosition.setPosition(carPosition.getPosition() + n);
        return true;
    }
}