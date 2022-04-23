package racingcar.domain;

import racingcar.domain.model.CarName;
import racingcar.domain.model.Distance;
import racingcar.domain.model.RaceRecordBoard;
import racingcar.domain.model.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private final String[] names;
    private final RaceRecordBoard recordBoard;
    private final int moveTryLimit;
    private final List<RacingCar> carList;

    public CarFactory(String[] carNames, int moveTryLimit, RaceRecordBoard board) {
        this.names = carNames;
        this.recordBoard = board;
        this.moveTryLimit = moveTryLimit;
        this.carList = new ArrayList<>();
    }

    /**
     * 차량 객체 생성
     */
    public void createCars() {
        if (names.length != 0) {
            for (String n : names) {
                carList.add(new RacingCar(
                        new CarName(n),
                        new Distance(moveTryLimit),
                        recordBoard));
            }
        }
    }

    /**
     * 차량 리스트 반환
     */
    public List<RacingCar> getCarList(){
        return carList;
    }
}
