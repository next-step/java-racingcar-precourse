package racingcar.domain;

import racingcar.exception.RaceRecordException;

import java.util.ArrayList;
import java.util.List;

import static racingcar.domain.constant.RacingCarConstant.DISTANCE_SIGN;
import static racingcar.domain.constant.RacingCarConstant.LABEL_SEPARATOR;

public class RaceRecords {
    private List<LapTime> raceRecords = new ArrayList<>();
    private int lap;

    public RaceRecords() {
        this.lap = 0;
    }

    public void saveLapTime(List<Car> cars) {
        if (cars == null) {
            throw new RaceRecordException.UnRecordableTypeException();
        }
        cars.forEach(car -> raceRecords.add(map(car)));
        lap++;
    }

    private LapTime map(Car car) {
        return new LapTime(lap, car.getCarName(), car.getDistance());
    }

    public String getRaceRecords() {
        StringBuilder sb = new StringBuilder();
        int prevLap = 0;
        for (LapTime lapTime : raceRecords) {
            sb.append(nextLap(prevLap, lapTime.getLap()));
            sb.append(lapTime.getCarName() + LABEL_SEPARATOR);
            sb.append(DISTANCE_SIGN.repeat(lapTime.getDistance()) + "\n");
            prevLap = lapTime.getLap();
        }
        return sb.toString();
    }

    private String nextLap(int prevLap, int currentLap) {
        if (prevLap != currentLap) {
            return "\n";
        }
        return "";
    }
}
