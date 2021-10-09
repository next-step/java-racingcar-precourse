package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<Car> carList;
    private int count;

    // Ex, pobi,crong,honux
    public RacingGame(String cars, int count){
        this.carList = new ArrayList<>();
        this.count = count;
        String[] carArrays = cars.split(",");
        for (String carName : carArrays){
            carList.add(new Car(carName));
        }
    }

    public void printSteps(){
        for (Car car : carList){
            car.printCurrentStep();
        }
        System.out.println();
    }

}
