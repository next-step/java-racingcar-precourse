package view;

import domain.Car;
import domain.Cars;

import java.util.List;

public class OutputView {

    public void printWinnerCars(Cars winners) {
        System.out.println(winners.toString() + "가 최종 우승하였습니다.");
    }

    public void printGameStatus(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.toString());
        }
        System.out.println();
    }
}
