package racinggame.domain;

public class Validation {

    public static final int NAME_MAX_LEN = 5;
    public static final int NAME_MIN_LEN = 0;

    public Validation() {
    }

    public Boolean checkCarNmaeLen(String carName) {
        return carName.length() <= NAME_MAX_LEN && carName.length() > NAME_MIN_LEN;
    }

    public Boolean checkCarsNameNull(String carsName) {
        return carsName.length() != NAME_MIN_LEN;
    }

    public Boolean checkCarsListNull(String[] cars) {
        return cars.length != NAME_MIN_LEN;
    }

    public Boolean checkChancesRange(int chances) {
        return chances > NAME_MIN_LEN;
    }
}
