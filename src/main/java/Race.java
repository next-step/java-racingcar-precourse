import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {

    private List<Car> cars;
    private int attempts;

    public Race(List<String> carNames, int attempts) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        this.attempts = attempts;
    }

    public List<Car> getWinners(){
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<Car> winners = new ArrayList<>();
        for(Car car : cars){
            if(car.getPosition() == maxPosition){
                winners.add(car);
            }
        }
        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }

}