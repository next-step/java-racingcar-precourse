public class Car {
    public static final int MOVE_THRESHOLD = 4;
    public static final int MILEAGE_INITIAL_VALUE = 0;
    CarName carName;
    Mileage mileage;

    private Car(CarName carName) {
        this.carName = carName;
        this.mileage = Mileage.of(MILEAGE_INITIAL_VALUE);
    }

    public static Car of(String carName) {
        return new Car(CarName.of(carName));
    }

    public void move(Integer input) {
        if (input >= MOVE_THRESHOLD) {
            mileage.addOne();
        }
    }

    public void randomMove() {
        move(Utility.generateRandomSingleDigitInteger());
    }

    public CarName getCarName() {
        return carName;
    }

    public Mileage getMileage() {
        return mileage;
    }
}
