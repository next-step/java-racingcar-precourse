package racingcar.domain;

import racingcar.domain.model.Distance;
import racingcar.domain.model.RaceRecordBoard;
import racingcar.domain.model.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    private final String[] names;
    private final RaceRecordBoard board;
    private final int moveTryLimit;
    private final List<RacingCar> carList;

    public CarFactory(String carNames, int moveTryLimit, RaceRecordBoard board) {
        this.names = carNames.split(",");
        this.board = board;
        this.moveTryLimit = moveTryLimit;
        this.carList = new ArrayList<>();
    }

    /**
     * 차량 객체 생성
     */
    public void createCars() {
        if (names.length != 0) {
            for (String name : names) {
                carList.add(new RacingCar(name, new Distance(moveTryLimit), board));
            }
        }
    }

    public List<RacingCar> getCarList(){
        return carList;
    }
}
