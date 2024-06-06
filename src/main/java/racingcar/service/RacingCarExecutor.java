package racingcar.service;

import racingcar.dto.RacingCarDto;
import racingcar.entity.RacingCar;

import java.util.List;

public class RacingCarExecutor {
    private final List<RacingCar> racingCars;

    public RacingCarExecutor(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
        if (racingCars.isEmpty()) {
            throw new IllegalArgumentException("racing car list is empty");
        }
    }

    public List<RacingCarDto> execute() {
        return racingCars.stream()
                .peek(racingCar -> {
                    int randomNumber = (int) (Math.random() * 10);
                    if (randomNumber >= 4) {
                        racingCar.forward();
                    }
                })
                .map(RacingCarDto::parse)
                .toList();
    }

    public List<RacingCarDto> getWinner() {
        int maxLocation = racingCars.stream()
                .mapToInt(RacingCar::getLocation)
                .max()
                .orElse(Integer.MIN_VALUE);

        return racingCars.stream()
                .filter(racingCar -> maxLocation == racingCar.getLocation())
                .map(RacingCarDto::parse)
                .toList();
    }
}
