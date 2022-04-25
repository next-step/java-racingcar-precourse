package racingcar.car;

public class LengthCarNameValidator implements CarNameValidator {

    private Integer maxLength;

    public LengthCarNameValidator(Integer maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public void validCarName(CarName carName) {
        if (carName.length() > maxLength) {
            throw new IllegalArgumentException(
                    "[ERROR] CarName은 " + this.maxLength + "자를 넘을 수 없습니다. now : " + carName.name());
        }
    }

}
