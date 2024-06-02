package Racing.service;

import Racing.domain.Car;
import Racing.domain.Cars;
import Racing.util.GenerateRandomNumber;


public class ScoreService {
    GenerateRandomNumber randomNumberGenerator = new GenerateRandomNumber();

    public void saveScore(Cars cars){
        for(Car car :cars.getCars()){
            if(getScore()) car.plusDistanceBar();
        }

    }

    private boolean getScore(){
        return randomNumberGenerator.getRandomNumber()>=4;
    }

}
