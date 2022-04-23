package racingcar.controller;

import racingcar.model.RacingCar;

import java.util.List;

public class RacingCarResultDto {
    private String name;
    private List<Integer> positionHistory;

    public RacingCarResultDto(String name, List<Integer> positionHistory) {
        this.name = name;
        this.positionHistory = positionHistory;
    }

    public static RacingCarResultDto from(RacingCar racingCar) {
        return new RacingCarResultDto(racingCar.getName(), racingCar.getPositionHistories());
    }

    public String getName() {
        return name;
    }

    public List<Integer> getPositionHistory() {
        return positionHistory;
    }
}
