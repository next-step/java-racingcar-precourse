package racingcar.model;

import racingcar.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final List<Car> raceCars;
    private static int trial;
    private int trialNumber = 0;

    public Game(){
        Game.trial = 0;
        raceCars = new ArrayList<>();
    }

    public List<Car> getRaceCars(){
        return raceCars;
    }

    public void setRaceCars(String[] carsName){
        for (String s : carsName) {
            raceCars.add(new Car(s));
        }
    }

    public void setTrial(int trial){
        Game.trial = trial;
    }

    public void play(){
        moveForward();
        increaseTrialNumber();
    }

    public Boolean isGameEnd(){
        return trial == this.trialNumber;
    }

    public List<Car> getWinners() {
        return raceCars.stream()
                .filter(c -> c.getPosition() == getMaxPosition(raceCars))
                .collect(Collectors.toList());
    }

    private void increaseTrialNumber(){
        this.trialNumber += 1;
    }

    private void moveForward(){
        for (Car car : raceCars){
            car.move(RandomNumberGenerator.generate());
        }
    }

    private int getMaxPosition(List<Car> cars){
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
