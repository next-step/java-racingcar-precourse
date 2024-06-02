package Model;

import View.Output;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int move;

    public Race(List<Car> cars, int move){
        this.cars = cars;
        this.move = move;
    }

    public void startRace(){
        for(int i=0; i< move; i++ ){
            for(int j =0; j<cars.size(); j++){
                cars.get(j).move();
            }
            Output.printCarStatus(cars);
        }
    }

    public List<String> getWinners(){
        int maximum = 0;
        for (int i=0; i<cars.size(); i++){
            maximum = Math.max(maximum, cars.get(i).getPosition());
        }
        List<String> winners = new ArrayList<>();
        for (int i=0; i<cars.size(); i++){
            if (cars.get(i).getPosition() == maximum) {
                winners.add(cars.get(i).getName());
            }
        }

        return winners;
    }

}
