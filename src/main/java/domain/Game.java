package domain;

import utils.RandomNumber;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Game {

    private Map<String, Integer> carState;
    private Car car;

    private int startNumber;
    private int endNumber;

    RandomNumber randomNumber;

    public Game(Car car, int startNumber, int endNumber) {
        this.car = car;
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        carState = new HashMap<String,Integer>();
        randomNumber = new RandomNumber(this.startNumber,this.endNumber);
        for(String carName: this.car.getCars()){
            carState.put(carName,0);
        }
    }
    public Map<String, Integer> getCarState(){
        return carState;
    }

    public void challengeMove(){
        for(String carName: car.getCars()){
            decideMove(carName);
        }
    }
    private void decideMove(String name){
        if(randomNumber.getNumber()>=4){
            carState.put(name,carState.get(name)+1);
        }
    }

    private int highScore(){
        return Collections.max(carState.values());
    }
    public String getWinner(){
        int highScore= highScore();
        String winners="";
        for(String carName: car.getCars()){
            if(carState.get(carName)==highScore){
                winners+=carName+",";
            }
        }
        return winners;
    }

}
