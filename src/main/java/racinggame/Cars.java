package racinggame;

import java.util.ArrayList;
import java.util.List;

import static racinggame.ErrorMessage.ERROR_MESSAGE;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public void enterName(String carName) {
        String[] split = carName.split(",");

        for (String name : split) {
            checkLength(name);
            cars.add(new Car(name));
        }
    }

    private void checkLength(String carName) {
        if(carName.length() > 5)
            throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    public List<Car> getCars() {
        return cars;
    }
}
