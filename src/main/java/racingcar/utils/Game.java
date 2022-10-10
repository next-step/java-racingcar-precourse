package racingcar.utils;

import racingcar.entities.Car;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static void playGame(ArrayList<Car> cars) {
        for (Car car : cars) {
            car.proceedGameOnce();
            System.out.println(car.getName() + " : " + car.getDistanceBar());
        }
        System.out.println("\n");
    }

    public ArrayList<Car> pickWinnerCars(List<Car> cars) {
        ArrayList<Car> winnerCars = new ArrayList<>();
        int maxDistance = getMaxDistance(cars);
        for (Car car : cars) {
            checkIfThisCarIsWinner(winnerCars, maxDistance, car);
        }
        return winnerCars;
    }

    private static void checkIfThisCarIsWinner(ArrayList<Car> winnerCars, int maxDistance, Car car) {
        if(car.isCarWinner(maxDistance))
            winnerCars.add(car);
    }

    private static int getMaxDistance(List<Car> cars) {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = car.getFurtherDistance(maxDistance);
        }
        return maxDistance;
    }
}
