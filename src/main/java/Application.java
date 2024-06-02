import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String carNames = getCarNames(scanner);
        int tryCount = getTryCount(scanner);

        RacingGame racingGame = new RacingGame(carNames, tryCount);
        racingGame.startRace();
        printWinners(racingGame);
    }

    private static String getCarNames(Scanner scanner) {
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                String carNames = scanner.nextLine();
                validateCarNames(carNames);
                return carNames;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public static void validateCarNames(String carNames) {
        for (String name : carNames.split(",")) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    private static int getTryCount(Scanner scanner) {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private static void printWinners(RacingGame racingGame) {
        int maxPosition = racingGame.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        String winners = racingGame.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winners);
    }
}

class Car {
    private final String name;
    private int position = 0;
    private final Random random = new Random();

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
        this.name = name;
    }

    public void move() {
        if (random.nextInt(10) >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

class RacingGame {
    private final List<Car> cars;
    private final int tryCount;

    public RacingGame(String carNames, int tryCount) {
        this.cars = new ArrayList<>();
        this.tryCount = tryCount;

        for (String name : carNames.split(",")) {
            cars.add(new Car(name));
        }
    }

    public void startRace() {
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.move();
            }
            // 각 시도 후에 결과를 출력합니다.
            Application.printRoundResult(cars);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }
}





