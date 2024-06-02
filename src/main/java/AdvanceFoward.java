import java.util.Random;
import java.util.Vector;

public class AdvanceFoward {
    public static void advanceFoward(Vector<Car> cars, int attemptnumber) {
        for(int i = 0; i < attemptnumber; i++) {
            for(int j = 0; j < cars.size(); j++) {
                Random random = new Random();
                cars.stream().filter(c -> random.nextInt() % 10 >= 4).forEach(c -> c.increaseNumber());
            }
            OutputHandler.fowardOutput(cars);
        }

    }

}
