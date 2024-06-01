import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private List<Car> cars;

    public Race(List<String> carNames) {
        cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public void start(int trials) {
        for (int i = 0; i < trials; i++) {
            for (Car car : cars) {
                int randomValue = (int) (Math.random() * 10);
                car.move(randomValue);
            }
            printStatus();
        }
    }

    private void printStatus() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

}
