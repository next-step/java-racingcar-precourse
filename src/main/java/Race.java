import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Race {
    private final Car[] cars;

    public Race(String[] carNames) {
        cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    public void moveCars(Random random) {
        for (Car car : cars) {
            car.move(random.nextInt(10));
        }
    }

    public Car[] getCars() {
        return cars;
    }
    public String findWinners() {
        int maxPosition = Arrays.stream(cars)
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);

        return Arrays.stream(cars)
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .collect(Collectors.joining(", "));
    }


}
