package racingcar.damain;

import java.util.ArrayList;
import java.util.List;
import racingcar.utils.ScannerUtil;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public Cars() {
        List<String> carList = ScannerUtil.inputCarsName();
        for (String carName : carList)
            cars.add(new Car(carName));
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void tryOutMove() {
        for (Car car : cars)
            car.tryoutMove();
    }

    public List<Car> getWinners(int positionFirst) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars)
            car.addWinnerCar(winners, positionFirst);
        return winners;
    }

    public void showRace() {
        for (Car car : cars)
            car.showRace();
    }
}
