package racingcar.model;

import racingcar.exception.RacingCarsDuplicationException;
import racingcar.exception.RacingCarsMaxSizeException;
import racingcar.message.ExceptionMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCarCenter {
    private static final int RACING_CAR_MAX_SIZE = 100;

    private final List<RacingCar> racingCars;

    public RacingCarCenter(List<RacingCar> racingCars) throws RacingCarsDuplicationException {
        checkRacingCarsSize(racingCars);
        checkCouponsDuplicate(racingCars);
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }

    private void checkCouponsDuplicate(List<RacingCar> racingCars) {
        Set<String> noDuplicateRacingCarTrack = new HashSet<>();
        for (int i = 0; i < racingCars.size(); i++) {
            noDuplicateRacingCarTrack.add(racingCars.get(i).getName());
        }
        if (noDuplicateRacingCarTrack.size() != racingCars.size()){
            throw new RacingCarsDuplicationException(ExceptionMessage.RACING_CAR_NAME_DUPLICATION_EXCEPTION_MESSAGE);
        }
    }

    private void checkRacingCarsSize(List<RacingCar> racingCars) {
        if (racingCars.size() > RACING_CAR_MAX_SIZE) {
            throw new RacingCarsMaxSizeException(ExceptionMessage.RACING_CAR_MAX_SIZE_EXCEPTION_MESSAGE);
        }
    }
}
