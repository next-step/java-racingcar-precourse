import java.util.Random;
import java.util.Vector;

public class AdvanceFoward {
    public static void advanceFoward(Vector<Car> cars, int attemptnumber) {
        for(int i = 0; i < attemptnumber; i++) {
            for(int j = 0; j < cars.size(); j++) {
                Random random = new Random();
                int random_number = random.nextInt() % 10;
                if(random_number >= 4) {
                    cars.elementAt(j).increaseNumber();
                }
            }
            OutputHandler.fowardOutput(cars);
        }

    }

}
