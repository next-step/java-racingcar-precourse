package controller;
import java.util.ArrayList;
import java.util.List;
import model.*;
import util.MaxValueFinder;
import util.RandomGenerator;
import view.*;

public class GameController {

    public static void startGame() {
        String[] carNamesArray = getCarNames(InputView.getFirstInput());
        int n = InputView.getSecondInput();
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

    private static void findWinner(List<Car> cars) {
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

    public static String[] getCarNames(String input) {
        String[] result = input.replaceAll("\\s+", "").split(",");
        return result;
    }

    public static boolean checkCarNameLength(String name) {
        int length = name.length();
        if (length < 1 || length > 5) {
            return false;
        }
        return true;
    }
}
