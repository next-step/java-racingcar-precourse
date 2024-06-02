import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int rounds;
    private final List<StringBuilder> raceHistory;

    public Race(List<String> carNames, int rounds) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        this.rounds = rounds;
        this.raceHistory = new ArrayList<>();
    }

    public void start() {
        for (int i = 0; i < rounds; i++) {
            StringBuilder roundResult = new StringBuilder();
            for (Car car : cars) {
                car.move();
                roundResult.append(car.getName()).append(" : ").append("-".repeat(car.getPosition())).append("\n");
            }
            raceHistory.add(roundResult);
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

    public List<StringBuilder> getRaceHistory() {
        return raceHistory;
    }
}