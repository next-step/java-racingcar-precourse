package racingcar;


import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    List<Car> carList = new ArrayList<>();

    public void carEvent(List<Car> carList) {
        for (Car car : carList){
            car.forward(new Forward().isForwardCondition());
        }
    }
}
