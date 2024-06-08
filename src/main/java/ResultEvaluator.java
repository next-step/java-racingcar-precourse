import java.util.List;

public class ResultEvaluator {
    public List<String> getWinners(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);

        return cars.stream().filter(car -> car.getPosition() == maxPosition).map(Car::getName).toList();
    }
}
