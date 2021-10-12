package racinggame;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarController {
    public static final int MIN_NO = 1;
    public static final int MAX_NO = 9;

    List<Car> raceCars = new ArrayList<Car>();
    Cars raceCar2 = new Cars(raceCars);

    public int gameCount;

    public void createCar(String carName){
        String[] cars = carName.split(",");
        for (String car : cars) {
            raceCars.add(new Car(car));
        }
    }

    public void carRaceStart(){
        for(int i=0; i<getGameCount(); i++){
            carGoStopInput();
        }
    }

    public void carGoStopInput(){
        for(int j=0; j<raceCars.size(); j++){
            raceCar2.findCar(j).goStopCheck(Randoms.pickNumberInRange(MIN_NO,MAX_NO));
            System.out.println(raceCar2.findCar(j).getCarNumGoSize());
        }
        System.out.println("");
    }

    public void setGameCount(String gameCount) {
        this.gameCount = Integer.parseInt(gameCount);
    }

    public int getGameCount(){
        return this.gameCount;
    }

}
