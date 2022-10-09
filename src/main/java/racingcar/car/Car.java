package racingcar.car;

public class Car {

    private static final int NEXT_LIMIT = 4;

    private CarName carName;

    public Car(String name) {
        carName = new CarName(name);
    }

    public CarStatus play(int carMove) {
        if(carMove >= NEXT_LIMIT) {
            return CarStatus.NEXT;
        }
        return CarStatus.STOP;
    }

    public String getName() {
        return carName.getName();
    }
}
