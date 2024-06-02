package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class CarList {
    private List<Car> cars;
    private static final int MOVE_THRESHOLD = 4;
    private Random random;
    private Scanner scanner;

    public CarList(List<String> carNames) {
        this.scanner = new Scanner(System.in);
        this.random = new Random();

        while (true) {
            if (hasDuplicateNames(carNames)) {
                System.out.println("[ERROR] 중복된 자동차 이름이 존재합니다.");
                System.out.print("다시 입력해주세요: ");
                String input = scanner.nextLine();
                carNames = parseInput(input);
                continue;
            }
            if (hasInvalidName(carNames)) {
                System.out.println("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
                System.out.print("다시 입력해주세요: ");
                String input = scanner.nextLine();
                carNames = parseInput(input);
                continue;
            }
            break;
        }

        this.cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    private boolean hasDuplicateNames(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        return uniqueNames.size() != names.size();
    }

    private boolean hasInvalidName(List<String> names) {
        for (String name : names) {
            if (name.length() > 5) {
                return true;
            }
        }
        return false;
    }

    private List<String> parseInput(String input) {
        String[] names = input.split(",");
        return List.of(names);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void raceOnce() {
        for (Car car : cars) {
            if (random.nextInt(10) >= MOVE_THRESHOLD) {
                car.move();
            }
        }
    }

    public List<String> findWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}