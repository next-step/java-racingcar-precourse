public class CarName {
    String carName;

    private CarName(String carName) {
        this.carName = carName;
    }

    public static CarName of(String carName) {
        return new CarName(carName);
    }
}
