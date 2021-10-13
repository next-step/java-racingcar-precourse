package racinggame;

import java.util.LinkedHashMap;
import java.util.Map;

import static nextstep.utils.Randoms.pickNumberInRange;

public class RacingCar {
    private final Cars cars;
    private RaceCount raceCount;

    public RacingCar(String carNames) {
        this.cars = new Cars(carNames);
        this.raceCount = new RaceCount(0);
    }

    public int getRaceCount() {
        return raceCount.getCount();
    }

    public void setRaceCount(int count) {
        this.raceCount = new RaceCount(count);
    }

    public Map<String, Integer> race(){
        Map<String, Integer> racingResult = new LinkedHashMap<>();
        for (Car car : cars.getCarList()) {
            car.move(Car.judgeMoving(pickNumberInRange(1, 9)));
            racingResult.put(car.getName(), car.getPosition());
        }
        return racingResult;
    }

    public String getWinnerCarNames() {
        StringBuilder winnerCarNames = new StringBuilder();
        for (Car winnerCar : cars.getWinnerCarList()) {
            winnerCarNames.append(winnerCar.getName()).append(",");
        }
        return winnerCarNames.substring(0, winnerCarNames.length()-1);
    }


}
