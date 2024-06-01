import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Race {
    private List<Car> cars;
    private Random random;

    public Race(List<String> carNames){
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.random=new Random();
    }

    public void moveCars(){
        for (Car car : cars){
            car.move(random.nextInt(10));
        }
    }

    public List<Car> getWinner(){
        int maxPosition=cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car->car.getPosition()==maxPosition)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
