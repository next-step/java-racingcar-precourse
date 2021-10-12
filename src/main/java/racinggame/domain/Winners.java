package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private static final String COMMA = ",";
    private Cars cars;

    public Winners(Cars resultCars) {
        this.cars = resultCars;
    }

    public String getWinners(){
        int maxMoveCount = putMaxMoveCount();

        List<String> carList = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            addWinner(cars.getCar(i),maxMoveCount,carList);
        }

        return String.join(COMMA,carList);
    }

    private void addWinner(Car car, int maxMoveCount, List<String> carList) {
       if(car.getMoveCount() == maxMoveCount){
           carList.add(car.getName());
       }
    }

    private int putMaxMoveCount(){
        int maxMoveCount = Integer.MIN_VALUE;

        for (int i = 0; i < cars.size(); i++) {
            maxMoveCount = Math.max(maxMoveCount,cars.getCar(i).getMoveCount());
        }

        return maxMoveCount;
    }
}
