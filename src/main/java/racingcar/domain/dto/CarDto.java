package racingcar.domain.dto;

public class CarDto {
    private static final String PROGRESS_BAR = "-";

    private String carName;
    private int position;

    public CarDto(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionBarString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append(PROGRESS_BAR);
        }
        return builder.toString();
    }
}
