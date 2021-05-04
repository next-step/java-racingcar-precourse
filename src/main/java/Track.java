import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Track {
    List<Car> carList;

    public Track() {
        this.carList = new ArrayList<>();
    }

    public void addCar(Car car) {
        this.carList.add(car);
    }

    public void race() {
        for (Car car: carList) {
            car.moveOrDont(generateAccelValue());
        }
    }

    private int generateAccelValue() {
        return ThreadLocalRandom.current().nextInt(1, 9);
    }

    public Car getCar(int i) {
        return this.carList.get(i);
    }
}
