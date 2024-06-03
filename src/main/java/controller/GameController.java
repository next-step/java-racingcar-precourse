package controller;
import java.util.ArrayList;
import java.util.List;
import model.*;
import util.*;
import view.*;

public class GameController {
    public static void startGame() {
        String[] carNamesArray = createCars();
        int n = getRacingCount();
        List<Car> cars = new ArrayList<>();
        for (String s : carNamesArray) {
            Car car = new Car(s);
            cars.add(car);
        }
        playGame(n, cars);
    }

    public static void playGame(int n, List<Car> cars) {
        System.out.println("실행 결과");
        for (int i = 0; i < n; i++) {
            cars.forEach(car -> {
                if (RandomGenerator.isMoreThanFour()) {
                    car.moveForward();
                }
                String carName = car.getName();
                String progressLine = car.getProgressLine();
                OutputView.printResult(carName, progressLine);
            });
            System.out.println();
        }
        findWinner(cars);
    }

    public static void findWinner(List<Car> cars) {
        int maxDistance = MaxValueFinder.getMaxDistance(cars);
        ArrayList<String> winners = new ArrayList<>();
        cars.forEach(car -> {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        });
        String resultMessage = String.join(", ", winners);
        OutputView.printWinner(resultMessage);
    }

    public static String[] createCars() {
        while(true) {
            try {
                String input = InputView.getFirstInput();
                String[] carArray = input.replaceAll("\\s+", "").split(",");
                Validator.validateNameLength(carArray);
                Validator.validateArrayExistence(carArray);
                return carArray;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public static int getRacingCount() {
        while (true) {
            try {
                String input = InputView.getSecondInput();
                int n = Validator.validateNumberFormat(input);
                return n;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
