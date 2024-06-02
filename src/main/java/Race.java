import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int rounds;

    public Race(List<String> carNames, int rounds) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        this.rounds = rounds;
    }

    public void start() {
        for (int i = 0; i < rounds; i++) {
            for (Car car : cars) {
                car.move();
            }
        }
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}