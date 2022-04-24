package racingcar;

import java.util.List;
import racingcar.util.ErrorMessageUtil;

public class Race {
    public static final String MESSAGE_FORMAT_INVALID_RACE_STATUS = "경주를 할 수 있는 상태가 아닙니다. carSize: %d, lap: %d";
    private RaceStatus raceStatus;
    private CarList cars;
    private Lap lap;

    public Race() {
        init();
    }

    public void setCarList(String carNames) {
        cars = new CarList(carNames);
        changeRaceStatus();
    }

    public void setLap(String inputLap) {
        lap.setLap(inputLap);
        changeRaceStatus();
    }

    public void race() {
        checkRaceCondition();
        cars.race(lap.getLapCount());
        raceStatus = RaceStatus.RACE_END;
    }

    public List<Car> getWinner() {
        return cars.getTopRankers();
    }

    public boolean isCarReady() {
        return raceStatus.isCarReady();
    }

    public boolean isRaceReady() {
        return raceStatus.isRaceReady();
    }

    private void init() {
        raceStatus = RaceStatus.INIT;
        cars = new CarList();
        lap = new Lap();
    }

    private void changeRaceStatus() {
        if (cars.isNotEmpty() && lap.isNotEmpty()) {
            raceStatus = RaceStatus.RACE_READY;
            return;
        }

        if (cars.isNotEmpty()) {
            raceStatus = RaceStatus.CAR_READY;
            return;
        }

        if (lap.isNotEmpty()) {
            raceStatus = RaceStatus.LAP_READY;
        }
    }

    private void checkRaceCondition() {
        if (!raceStatus.isRaceReady()) {
            throw new IllegalStateException(ErrorMessageUtil.getMessage(
                    String.format(MESSAGE_FORMAT_INVALID_RACE_STATUS, cars.size(), lap.getLapCount())));
        }
    }
}
