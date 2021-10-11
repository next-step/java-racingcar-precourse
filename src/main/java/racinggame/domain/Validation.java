package racinggame.domain;

public class Validation {

    public Validation() {}

    public Boolean checkCarNmaeLen(String carName) {
        return carName.length() <= 5 && carName.length() > 0;
    }

    public Boolean checkCarsNameNull(String carsName) {
        return carsName.length() != 0;
    }

    public Boolean checkCarsListNull(String[] cars) {
        return cars.length != 0;
    }

    public Boolean checkChancesRange(int chances) {
        return chances > 0;
    }
}
