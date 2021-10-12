package racinggame;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
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

    public void play() {
        for (Car car : cars) {
            car.moved(Randoms.pickNumberInRange(0, 9));
        }
    }


    public List<String> getTopPlayer() {
        cars.sort(Collections.reverseOrder());

        return checkPosition(cars);
    }

    private List<String> checkPosition(List<Car> cars) {
        List<String> list = new ArrayList<>();

        int position = -1;
        int prePosition = -1;
        for (Car car : cars) {
            position = car.getPosition();
            if(prePosition != position && !list.isEmpty())
                break;

            list.add(car.getName());
            prePosition = position;
        }
        return list;
    }
}
