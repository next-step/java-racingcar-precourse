package controller;

public class Validation {
    public void isCarNameLengthUnderFive(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
