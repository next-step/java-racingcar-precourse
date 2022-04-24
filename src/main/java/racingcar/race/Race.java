package racingcar.race;

import java.util.List;
import java.util.Map;

import racingcar.car.Cars;

public class Race {
    Cars cars;
    int round = 0;

    public Race(Cars cars){
        this.cars = cars;
    }

    public void inputScoresToCars(){
        cars.inputScores();
    }

    public void finishRound(){
        this.round += 1;
    }

    public Map<String, Integer> getResultMap(){
        return cars.getMoveByName();
    }

    public int getRound(){
        return this.round;
    }

    public List<String> getWinners(){
        return cars.getWinners();
    }

}
