package racingcar.domain;

import racingcar.domain.model.CarName;
import racingcar.domain.model.Distance;
import racingcar.domain.model.RaceRecordBoard;
import racingcar.domain.model.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class CarFactory implements VehicleFactory <RacingCar> {
    private final String[] names;
    private final RaceRecordBoard recordBoard;
    private final int moveTryLimit;

    public CarFactory(String[] carNames, int moveTryLimit, RaceRecordBoard board) {
        this.names = carNames;
        this.recordBoard = board;
        this.moveTryLimit = moveTryLimit;
    }

    /**
     * 차량 객체 생성
     */
    @Override
    public List<RacingCar> creates() {
        List<RacingCar> carList = new ArrayList<>();
        if (names.length != 0) {
            for (String n : names) {
                carList.add(new RacingCar(
                        new CarName(n),
                        new Distance(moveTryLimit),
                        recordBoard));
            }
        }
        return carList;
    }
}
