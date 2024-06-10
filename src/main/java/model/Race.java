package model;

import java.util.List;
import java.util.ArrayList;
import view.Output;

public class Race {
    private final List<Car> cars;
    private final int move;

    public Race(List<Car> cars, int move) {
        this.cars = cars;
        this.move = move;
    }

    public void start(){
        for(int i = 0; i < move; i++) {
            for (Car car : cars) {
                car.move();
            }
            Output.printResult(cars);
        }
    }

    public List<String> getWinner() {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(max, car.getPos());
        }
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPos() == max) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
