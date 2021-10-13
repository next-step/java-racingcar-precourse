package racinggame;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CarController {
    public static final int MIN_NO = 1;
    public static final int MAX_NO = 9;

    List<Car> raceCars = new ArrayList<Car>();
    Cars cars = new Cars(raceCars);

    public int gameCount;
    int maxSize = 0;

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
            cars.findCar(j).goStopCheck(Randoms.pickNumberInRange(MIN_NO,MAX_NO));
            System.out.println(cars.findCar(j).getCarNumGoSize());
        }
        System.out.println("");
    }

    public void setGameCount(String gameCount) {
        this.gameCount = Integer.parseInt(gameCount);
    }

    public int getGameCount(){
        return this.gameCount;
    }

    public String raceResult(){
        return this.carsRank();
    }

    public String carsRank(){

        StringBuilder resultMsg = new StringBuilder();
        for(Car car: raceCars){
            resultMsg.append(compareSize(maxSize,car));
        }

        return resultMsg.toString();
    }

    public String compareSize(int firstSize, Car compareCar){
        if( firstSize == compareCar.getGoSize().length()){
            return ","+compareCar.getCarName();
        }
        if( firstSize < compareCar.getGoSize().length() ){
            maxSize = compareCar.getGoSize().length();
            return compareCar.getCarName();
        }
        if( firstSize > compareCar.getGoSize().length() ){
            return "";
        }
        return "";
    }

    public String validNumCheck(String size){
        if( size.isEmpty() ){
            return "[ERROR]";
        }
        return "";
    }
}
