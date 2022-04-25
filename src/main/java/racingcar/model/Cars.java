package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void forwardCars() {
        for(int i=0; i<cars.size(); i++) {
            cars.get(i).forward();
        }
    }

    public void printDistance() {
        for(int i=0; i<cars.size(); i++) {
            cars.get(i).printResult();
        }
        System.out.println("");
    }

    public void printWinner() {
        for(int i=0; i<getWinner().size(); i++) {
            System.out.print(getWinner().get(i));
            printSeparator(i);
        }
    }

    private void printSeparator(int i) {
        if(getWinner().size()-1 != i) {
            System.out.print(", ");
        }
    }

    public List<String> getWinner() {
        List<String> winners = new ArrayList<>();
        for(int i=0; i<cars.size(); i++) {
            findWinner(winners, i);
        }
        return winners;
    }

    private void findWinner(List<String> winners, int i) {
        if(cars.get(i).getDistance() == getMaxDistance()) {
            winners.add(cars.get(i).getName());
        }
    }

    private int getMaxDistance() {
        int maxDistance = 0;
        for(int i=0; i<this.cars.size(); i++) {
            maxDistance = compareDistance(maxDistance, i);
        }
        return maxDistance;
    }

    private int compareDistance(int maxDistance, int i) {
        if(maxDistance < cars.get(i).getDistance()) {
            maxDistance = cars.get(i).getDistance();
        }
        return maxDistance;
    }
}
