package racingcar.validators;

public class CarNameValidator implements Validator {

    private final String name;
    public CarNameValidator(String name) {
        this.name = name;
    }
    @Override
    public void validate() throws IllegalArgumentException {
        if (this.name.length() > 5 || this.name.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 5자 이내의 유효한 자동차 이름을 입력해주세요");
        }
    }
}
