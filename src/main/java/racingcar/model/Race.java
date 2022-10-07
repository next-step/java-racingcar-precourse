package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class Race {
    private final Cars cars;
    private final TryCount count;
    private final ArrayList<String> winnerNames;
    private int maxDistance;

    public Race(Cars cars, TryCount count) {
        this.cars = cars;
        this.count = count;
        this.maxDistance = 0;
        this.winnerNames = new ArrayList<>();
    }

    public List<Car> getCars() {
        return this.cars.getCars();
    }

    public int getCount() {
        return this.count.getCount();
    }

    public void run() {
        for(Car car : this.cars.getCars()){
            car.move(getRandomNumber());
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }


    public ArrayList<String> getWinnerNames() {
        setMaxDistance();
        setWinners();
        return this.winnerNames;
    }

    private void setMaxDistance() {
        for(Car car : this.cars.getCars()){
            if(car.getDistance() > this.maxDistance)
                this.maxDistance = car.getDistance();
        }
    }

    private void setWinners() {
        for(Car car : this.cars.getCars()){
            if(checkWinner(car)) this.winnerNames.add(car.getName());
        }
    }

    private boolean checkWinner(Car car){
        return car.getDistance() == this.maxDistance;
    }

}
