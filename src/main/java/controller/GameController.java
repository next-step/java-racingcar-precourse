package controller;
import java.util.ArrayList;
import java.util.List;
import model.*;
import util.MaxValueFinder;
import util.RandomGenerator;
import view.*;

public class GameController {
    public static void startGame() {
        String[] carNamesArray = createCars();
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

    public static String[] createCars() {
        while(true) {
            try {
                String input = InputView.getFirstInput();
                String[] carArray = input.replaceAll("\\s+", "").split(",");
                validateNameLength(carArray);
                validateArrayExistence(carArray);
                return carArray;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private static void validateArrayExistence(String[] carArray) {
        if (carArray.length == 0) {
            throw new IllegalArgumentException("[Error] 1개 이상의 자동자를 입력해야 합니다.");
        }
    }

    private static void validateNameLength(String[] carArray) {
        for (String name: carArray) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 자동자의 이름은 5자 이하이어야 합니다.");
            }
            if (name.length() < 1) {
                throw new IllegalArgumentException("[ERROR] 자동자의 이름은 1자 이상이어야 합니다.");
            }
        }
    }
}
