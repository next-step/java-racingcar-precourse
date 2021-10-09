package racinggame;

public class Validation {

    public Boolean checkCarNmaeLen(String carName) {
        return carName.length() <= 5;
    }
}
