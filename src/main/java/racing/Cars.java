package racing;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    
    private static List<Car> cars;
    
    public Cars(String userInput) {
        this.cars = carList(userInput);
    }
    
    private static List<Car> carList(String userInput) {
        List<Car> cars = new ArrayList<>();
        String[] carNameArray = userInput.split(",");
        
        for (int i = 0; i < carNameArray.length; i++) {
            cars.add(new Car(carNameArray[i]));
        }
        
        return cars;
    }
    
    
}
