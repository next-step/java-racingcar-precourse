package racingcar;

public class CarName {
    final String carName;

    public CarName(final String carName) throws IllegalArgumentException {
        validateCarName(carName);
        this.carName = carName;
    }

    private void validateCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("[ERROR]차의 이름 입력이 정상적이지 않습니다.");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("[ERROR]차의 이름은 5자 이하만 가능합니다.");
        }
    }

    @Override
    public String toString() {
        return carName;
    }
}
