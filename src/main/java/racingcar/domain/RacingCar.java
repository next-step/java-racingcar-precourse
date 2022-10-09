package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.RacingCarUtils;

import java.util.List;

public class RacingCar {
    private final List<Car> cars;

    public RacingCar(List<Car> cars) {
        this.cars = cars;
    }

    public void startRace(int round){
        for (int i = 0; i < round; i++) {
            race();
            RacingCarUtils.printRacingResultByEachRound(this.cars);
        }
    }

    public void race() {
        cars.forEach(
                car -> car.drive(Randoms.pickNumberInRange(0,9))
        );
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> rank() {
        this.cars.sort(Car.DISTANCE_COMPARATOR.reversed());
        return this.cars;
    }

    public String getWinner(){
        String winners = "";
        List<Car> rank = rank();
        for (int i = 0; i < rank.size() && rank.get(0).mileage() == rank.get(i).mileage(); i++) {
            winners += rank.get(i).getCarName() + ",";
        }
        return winners.substring(0, winners.length()-1);
    }
}
