import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int rounds;
    private final List<StringBuilder> raceHistory;

    public Race(List<String> carNames, int rounds) {
        this.cars = createCars(carNames);
        this.rounds = rounds;
        this.raceHistory = new ArrayList<>();
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void start() {
        for (int i = 0; i < rounds; i++) {
            StringBuilder roundResult = new StringBuilder();
            for (Car car : cars) {
                car.move();
                appendRoundResult(roundResult, car);
            }
            raceHistory.add(roundResult);
        }
    }

    private void appendRoundResult(StringBuilder roundResult, Car car) {
        roundResult.append(car.getName()).append(" : ").append("-".repeat(car.getPosition())).append("\n");
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }

    public List<StringBuilder> getRaceHistory() {
        return raceHistory;
    }
}