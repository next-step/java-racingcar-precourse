package service;

import domain.RacingCar;

import java.util.*;

public class RacingCarService {
    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final int FORWARD_NUMBER = 4;
    private List<RacingCar> racingCarList;

    public RacingCarService(){
    }

    public void save(List<RacingCar> racingCarList){
        this.racingCarList = racingCarList;
    }

    public void playRound(){
        for(RacingCar racingCar: racingCarList){
            if(generateRandomNumber()>=FORWARD_NUMBER){
                racingCar.move();
            }
        }
    }

    public int generateRandomNumber(){
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_RANGE);
    }

    public List<RacingCar> getWinners(){
        int maxMove = checkMaxMove();
        List<RacingCar> winners = new ArrayList<>();
        for(RacingCar car: racingCarList){
            if(maxMove==car.getMoveDistance()) winners.add(car);
        }
        return winners;
    }

    public int checkMaxMove(){
        return racingCarList.stream().mapToInt(RacingCar::getMoveDistance).max().orElse(0);
    }

    public List<RacingCar> getRacingCarList(){
        return racingCarList;
    }
}
