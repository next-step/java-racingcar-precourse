package racingcar.dto;

import racingcar.entity.RacingCar;

public class RacingCarDto {
    private final String name;
    private final int location;

    public RacingCarDto(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public static RacingCarDto parse(RacingCar racingCar) {
        return new RacingCarDto(racingCar.getName(), racingCar.getLocation());
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
