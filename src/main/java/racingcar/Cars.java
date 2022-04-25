package racingcar;

import racingcar.View.PositionOutput;
import racingcar.View.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void move() {
        MovableStrategy movableStrategy = new RandomMovableStrategy();
        for (int i = 0; i < cars.size(); i++){
            cars.get(i).move(movableStrategy);
            View.print(cars.get(i).getName().getName() + " : ");
            PositionOutput.out(cars.get(i).getPosition());
        }
    }

    public Cars getWinner(){
        List<Car> winner = new ArrayList<>();
        int maxPosition = getMaxPosition();
        extractWinner(winner, maxPosition);
        return new Cars(winner);
    }

    private int getMaxPosition() {
        List<Integer> positionList = new ArrayList<>();
        for (Car car : cars){
            positionList.add(car.getPosition().getPosition());
        }
        return Collections.max(positionList);
    }

    private void extractWinner(List<Car> winner, int maxPosition) {
        for (Car car : cars){
            comparePosition(winner, car, maxPosition);
        }
    }

    private void comparePosition(List<Car> winner, Car car, int maxPosition) {
        if (car.getPosition().getPosition() == maxPosition){
            winner.add(car);
        }
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");
        for (Car winner : cars) {
            joiner.add(winner.getName().getName());
        }
        return joiner.toString();
    }
}
