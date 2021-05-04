package racingcar;


import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    List<Car> carList;

    public RacingCars(String[] cars) {
        this.carList = new ArrayList<>();
        for(String name : cars){
            carList.add(new Car(name));
        }
    }

    public void carEvent() {
        for (Car car : carList){
            car.forward(new Forward().isForwardCondition());
        }
    }

    public void startRacing(int count) {
        for(int i=0; i<count; i++){
            carEvent();
        }
    }
}
