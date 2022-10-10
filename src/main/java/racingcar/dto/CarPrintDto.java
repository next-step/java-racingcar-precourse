package racingcar.dto;

public class CarPrintDto {
    private final String name;
    private final int distance;

    public CarPrintDto(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
