import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameService {

    private ArrayList<Car> cars = new ArrayList<>();
    private int tryCount;
    private ArrayList<String> winCarsName = new ArrayList<>();
    private RandomGenerator randomGenerator = new RandomGenerator();

    public GameService(int tryCount, String[] carNames) {
        this.tryCount = tryCount;
        for (String carName : carNames) {
            Car newCar = new Car(carName);
            cars.add(newCar);
        }
    }

    public void gameStart() {
        for (int i = 0; i < tryCount; i++) {
            carRace(); // if rand num >= 4: move
        }
        showResult();
    }

    public void carRace() {
        for (Car car : cars) {
            int n = randomGenerator.makeRandNum();
            if(n >= 4){
                car.move(); // distance += 1
            }
            car.showDistance();
        }
        System.out.println();
    }

    public void showResult() {
        int maxDistance = cars.get(0).getDistance();
        for (Car car : cars) {
            if(car.getDistance() > maxDistance){
                maxDistance = car.getDistance();
            }
        }
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winCarsName.add(car.getName());
            }
        }
        System.out.print("final winner: ");
        for (String name : winCarsName) {
            System.out.print(name + " ");
        }
    }

}
