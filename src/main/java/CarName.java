public class CarName {
    private String carName;
    private final int CAR_NAME_MAX_LENGTH = 5;

    public CarName(String carName) {
        validCarNameLength(carName);
        this.carName = carName;
    }

    private void validCarNameLength(String carName) {
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String toString() {
        return this.carName;
    }
}
