package Controller;

import Model.Car;
import VIew.Input;

import java.util.List;

import static Model.RandomNumber.generateRanNum;
import static VIew.Output.printCar;
import static VIew.Output.printWinner;

public class RacingCarController {
    public static void startGame() {
        List<Car> carList = Input.inputCars();
        int tryCount = Input.inputTryCount();

        for (int i = 0; i < tryCount; i++) {
            move(carList);
        }
    }

    public static void move(List<Car> carList) {
        for (int j = 0; j < carList.size(); j++) {
            Car curCar = carList.get(j);
            if (generateRanNum() >= 4) {
                curCar.move();
            }
            printCar(curCar);
        }
        System.out.println();

        printWinner(carList);
    }

    public static int winnerPos(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
