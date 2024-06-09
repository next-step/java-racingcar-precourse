package game.view;

import game.config.constant.Rule;
import game.domain.Car;
import game.domain.Cars;
import java.util.List;

public class OutputView {

    public void printResult(Cars cars) {
        List<Car> carList = cars.getCarList();
        carList.forEach(car -> System.out.println(car.getName() + " : " + Rule.CAR_POSITION_MAKER.repeat(car.getPosition())));
        System.out.println();
    }

}
