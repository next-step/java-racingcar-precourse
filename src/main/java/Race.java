import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;
    private final GameView gameView;

    public Race(String[] carNames) {
        this.gameView = new GameView();
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            this.cars.add(new Car(name));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void run(int attempts) {
        System.out.println("실행 결과");
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                car.move((int) (Math.random() * 10));
            }
        }
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
}
