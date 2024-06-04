import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameService {

    private ArrayList<Car> cars = new ArrayList<>();
    private int tryCount;
    private ArrayList<String> winCarsName = new ArrayList<>();

    public GameService(int tryCount, String[] carNames) {
        this.tryCount = tryCount;
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }

    public ArrayList<String> getWinCarsName() {
        return winCarsName;
    }


}
