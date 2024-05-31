package VIew;

import Controller.RacingCarController;
import Model.Car;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.max;

public class Output {
    public static void printCar(Car car) {
            System.out.print(car.getName() + " : ");
            System.out.println(car.getPosUnits(car.getPosition()));
    }

    public static void printWinner(List<Car> carList) {

        int winnerPosition = RacingCarController.winnerPos(carList);

        List<String> winners = carList.stream()
                .filter(car -> car.getPosition() == winnerPosition)
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
