package racingcar.domain;

public class CarDTO {
    private final String name;
    private final Integer distance;

    public CarDTO(final String name, final Integer distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }
}
