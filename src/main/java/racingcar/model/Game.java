package racingcar.model;

import java.util.ArrayList;
import java.util.List;

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

    private void increaseTrialNumber(){
        this.trialNumber += 1;
    }

    private void moveForward(){
        for (Car car : raceCars){
            car.move(RandomNumberGenerator.generate());
        }
    }
}
