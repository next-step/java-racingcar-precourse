package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    
    private static List<Car> cars;
    
    public Cars(String userInput) {
        this.cars = carList(userInput);
    }
    
    public PlayResult play() {
        PlayResult result = new PlayResult();
        RandomNumber random;
        
        for (int i = 0; i < cars.size(); i++) {
            random = new RandomNumber();
            cars.get(i).play(random.getRandomNumber());
        }
        
        return result;
    }
    
    public List<Car> getCars() {
        return cars;
    }
    
    private static List<Car> carList(String userInput) {
        List<Car> cars = new ArrayList<>();
        String[] carNameArray = userInput.replace(" ", "").split(",");
        
        for (int i = 0; i < carNameArray.length; i++) {
            cars.add(new Car(carNameArray[i]));
        }
        
        return cars;
    }
    
}
