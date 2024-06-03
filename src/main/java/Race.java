import java.util.List;

public class Race {
    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (randomNumberGenerator.generate() >= 4) {
                car.move();
            }
        }
    }

    public void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + ": " + car.getPositionAsString());
        }
    }
}
