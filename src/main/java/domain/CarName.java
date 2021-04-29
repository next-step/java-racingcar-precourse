package domain;

public class CarName {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private String name;

    public CarName(String name) {
        if(name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차의 이름은 %d글자를 넘어서는 안됩니다.", CAR_NAME_MAX_LENGTH));
        }

        this.name = name;
    }
}
