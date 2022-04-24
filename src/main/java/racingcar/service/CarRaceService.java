package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import javafx.util.Pair;
import racingcar.constant.Configuration;
import racingcar.domain.*;

import java.util.ArrayList;
import java.util.List;

public class CarRaceService {
    private CarEntry carEntry;
    private Circuit circuit;

    public CarRaceService(CarEntry carEntry, Circuit circuit) {
        this.carEntry = carEntry;
        this.circuit = circuit;
    }

    public Result start() {
        Result result = playCarRaceByRound();
        return result;
    }

    private Result playCarRaceByRound() {
        int totalRound = circuit.getRound();
        List<Record> recordList = new ArrayList<>();
        for (int i = 0; i < totalRound; i++) {
            Record record = goRandomDistance();
            recordList.add(record);
        }
        return new Result(recordList);
    }

    private Record goRandomDistance() {
        List<Car> cars = carEntry.getCars();
        List<Pair<String, Integer>> recordByRound = new ArrayList<>();
        cars.forEach(car -> {
            int distance = Randoms.pickNumberInRange(Configuration.MIN_DISTANCE, Configuration.MAX_DISTANCE);
            setDistanceOfCar(car, distance);
            Pair<String, Integer> record = new Pair<>(car.getName(), car.getDistance());
            recordByRound.add(record);
        });
        return new Record(recordByRound);
    }

    private void setDistanceOfCar(Car car, int distance) {
        if (distance < Configuration.MIN_ACCELERATOR) {
            return;
        }
        car.increaseDistance();
    }


}
