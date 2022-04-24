package racingcar.dto.response.car;

public class CarLocation {
    private static final String DISPLAY_SYMBOL = "-";

    private final int location;

    private CarLocation(int location) {
        this.location = location;
    }

    public static CarLocation from(int location) {
        return new CarLocation(location);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < location; i++) {
            stringBuilder.append(DISPLAY_SYMBOL);
        }
        return stringBuilder.toString();
    }
}
