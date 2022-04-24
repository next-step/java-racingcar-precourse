package racingcar.domain;

import utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class RacingCars {
    public static final String REGEX = ",";
    private final List<Car> cars = new ArrayList<>();

    public List<Car> makeCars(String input){
        List<String> carNameList = new ArrayList<>(makeCarNameList(input));
        ValidationUtils.validationCarNameList(carNameList);
        for(String each : carNameList){
            this.cars.add(new Car(each));
        }
        return this.cars;
    }
    public List<String> makeCarNameList(String input){
        List<String> carNames = new ArrayList<>();
        for(String each : input.split(REGEX)){
            String trimEach = each.trim();
            ValidationUtils.validationCarName(trimEach);
            carNames.add(trimEach);
        }
        return carNames;
    }
    public List<String> winnerList(){
        List<String> returnList = new ArrayList<>();
        int maxNumber = Collections.max(this.makePositionList());
        for(Car car:this.cars){
            if(maxNumber == car.getPosition()){
                returnList = car.addWinnerList(returnList);
            }
        }
        return returnList;
    }
    private List<Integer> makePositionList(){
        List<Integer> positions = new ArrayList<>();
        for(Car car:this.cars){
            positions.add(car.getPosition());
        }
        return positions;
    }
}
