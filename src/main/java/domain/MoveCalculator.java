package domain;

import java.util.ArrayList;
import java.util.List;

public class MoveCalculator {

    private static final int BASIC_NUM = 4;

    private static final int LIMIT_NUMBER_SIZE = 9;

    private int maxDistance = 0;

    private List<Car> winnerCars = null;

    public int getRandomValue(){
        return (int) (Math.random() * LIMIT_NUMBER_SIZE);
    }
    public void moveForward(Cars cars) {
        for(Car car : cars.getCars()){
            if(isGreaterThanCheckValue()) car.moveCar();
        }
    }

    public boolean isGreaterThanCheckValue() {
        return getRandomValue() >= BASIC_NUM;
    }

    public List<Car> getWinnerCar(List<Car> cars){
        winnerCars = new ArrayList<>();
        for(Car playingCar : cars){
            compareDistance(playingCar.getCarDistance().getDistance(), playingCar);
        }
        return  winnerCars;
    }

    private void compareDistance(int distance, Car playingCar){
        if(maxDistance == distance){
            winnerCars.add(playingCar);
        }

        if (maxDistance < distance) {
            maxDistance = distance;
            winnerCars.clear();
            winnerCars.add(playingCar);
        }
    }
}
