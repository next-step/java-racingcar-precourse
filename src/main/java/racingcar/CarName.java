package racingcar;

public class CarName {

    private static final String EMPTY_CAR_NAME = "[ERROR] 차량 이름이 비었습니다.";
    private static final String LONGER_THAN_FIVE_CAR_NAME = "[ERROR] 차량 이름은 5자 이하여야 합니다 [%s]";

    private String name;

    public CarName(String name) throws IllegalArgumentException {
        validateCarName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateCarName(String name) {
        if(name.trim().isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME);
        }
        if(name.length() > 5) {
            throw new IllegalArgumentException(
                    String.format(LONGER_THAN_FIVE_CAR_NAME, name)
            );
        }
    }
}
