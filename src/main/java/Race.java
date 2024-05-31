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

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
