package me.ascii92der.racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingResult {
    private final List<String> winners;
    private int winnersPosition;

    public RacingResult(List<Car> cars) {
        this.winnersPosition = getWinnersPosition(cars);
        this.winners = new ArrayList<>();
        cars.forEach(this::setWinner);
    }

    public int getWinnersPosition(List<Car> cars) {
        for (Car car : cars) {
            winnersPosition = Math.max(winnersPosition, car.getPosition());
        }
        return winnersPosition;
    }

    public void setWinner(Car car) {
        if(car.getPosition() == this.winnersPosition){
            winners.add(car.getCarName());
        }
    }
    public List<String> getWinners(){
        return winners;
    }
}
