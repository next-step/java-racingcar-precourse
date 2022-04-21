package racingcar.domain.dto;

public class RacingCarDto {
    private String name;
    private int distance;

    public RacingCarDto(String name, int distance) {
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
