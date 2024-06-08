import java.lang.reflect.Array;
import java.util.ArrayList;
import jdk.jfr.Description;

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
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            carRace(); // if rand num >= 4: move
        }
        showResult();
    }

    public void carRace() {
        for (Car car : cars) {
            int n = randomGenerator.makeRandNum();
            if (n >= 4) {
                car.move(); // distance += 1
            }
            car.showDistance();
        }
        System.out.println();
    }

    public void showResult() {
        getResult();
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winCarsName.size(); i++) {
            if (i != winCarsName.size() - 1) {
                System.out.print(winCarsName.get(i) + ", ");
            }
            if (i == winCarsName.size() - 1) {
                System.out.print(winCarsName.get(i));
            }
        }
    }

    private void getResult() {
        int maxDistance = cars.get(0).getDistance();
        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
            }
        }
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winCarsName.add(car.getName());
            }
        }
    }
}
