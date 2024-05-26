import java.util.ArrayList;
import java.util.List;

public class Race {
    private List<Car> cars;
    private int attempts;

    public Race(List<String> carNames, int attempts){
        this.cars = new ArrayList<>();
        for (String name : carNames){
            cars.add(new Car(name));
        }
        this.attempts = attempts;
    }

}
