package racinggame.game.model.car;

public class CarName {
    private static final int CAR_NAME_MAX_LENGTH = 5;

    private final String carName;
    private boolean isValid;

    public CarName(String carName) {
        this.carName = carName;
        setValid(carName);
    }

    public String getCarName() {
        return carName;
    }

    public boolean isValid() {
        return isValid;
    }

    private void setValid(String carName) {
        this.isValid = true;
        if(isWhiteSpace(carName)) {
            this.isValid = false;
        }
        if(isOverMaxLength(carName)) {
            this.isValid = false;
        }
    }

    private boolean isWhiteSpace(String value) {
        return "".equals(value.trim());
    }

    private boolean isOverMaxLength(String carName) {
        return carName.length() > CAR_NAME_MAX_LENGTH;
    }
}
