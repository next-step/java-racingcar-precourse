import java.util.Random;
import java.util.Vector;

public class AdvanceFoward {
    public static void advanceFoward(Vector<Car> cars) {
        Random random = new Random();
        for(int i = 0; i < cars.size(); i++) {
            int random_number = random.nextInt() % 10;
            if(random_number >= 4) {
                cars.elementAt(i).increaseNumber();
            }
        }
        OutputHandler.FowardOutput(cars);
    }

}
