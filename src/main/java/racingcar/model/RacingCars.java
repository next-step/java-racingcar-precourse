package racingcar.model;

import racingcar.policy.MovingPolicy;

import java.util.*;

import static racingcar.constant.RacingCarGameErrorMessage.ERROR_RACING_CARS_NAME_NOT_DUPLICATE;

public class RacingCars {

    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        validateDuplication(racingCars);
        this.racingCars = Collections.unmodifiableList(racingCars);
    }

    public void moveForwardWithAllRacingCar(MovingPolicy movingPolicy) {
        for (RacingCar racingCar : racingCars) racingCar.move(movingPolicy);
    }

    public RacingCarPosition getMaxPosition() {
        int max = Integer.MIN_VALUE;
        for (RacingCar racingCar : racingCars) max = Math.max(racingCar.getRacingCarPosition().get(), max);
        return new RacingCarPosition(max);
    }

    public List<WinningRacingCar> winningCars(RacingCarPosition maxRacingCarPosition) {
        List<WinningRacingCar> winningRacingCars = new ArrayList<>();
        for (RacingCar car : racingCars) {
            if (car.isSamePositionRacingCar(maxRacingCarPosition)) {
                winningRacingCars.add(new WinningRacingCar(car));
            }
        }
        return winningRacingCars;
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    public RacingCar getRacingCar(int index) {
        return racingCars.get(index);
    }
    
    private void validateDuplication(List<RacingCar> racingCars) {
        Set<RacingCar> racingCarSet = new HashSet<>(racingCars);

        if (racingCarSet.size() != racingCars.size()) {
            throw new IllegalArgumentException(ERROR_RACING_CARS_NAME_NOT_DUPLICATE);
        }
    }


}
