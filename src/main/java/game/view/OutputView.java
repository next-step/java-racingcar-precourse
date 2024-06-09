package game.view;

import game.config.constant.Rule;
import game.domain.Car;
import game.domain.Cars;
import game.view.constant.OutputMessage;
import java.util.List;

public class OutputView {

    public void printResult(Cars cars) {
        List<Car> carList = cars.getCarList();
        carList.forEach(car -> System.out.println(car.getName() + " : " + Rule.CAR_POSITION_MAKER.repeat(car.getPosition())));
        System.out.println();
    }

    public void printWinner(Cars cars) {
        System.out.print(OutputMessage.WINNER);
        Cars winners = cars.findWinners();
        String result = String.join(", ", winners.getCarNames());

        System.out.println(result);
    }

}
