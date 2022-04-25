package racingcar;

public class CarName {
    private String name;
    private final int MAX_NAME_SIZE = 5;

    public CarName(String car_name) {
        validate(car_name);
        name = car_name;
    }

    private void validate(String car_name) {
        if (car_name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(String.format("이름 길이 5자 규칙 초과 - 입력 길이: ", car_name.length()));
        }
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
