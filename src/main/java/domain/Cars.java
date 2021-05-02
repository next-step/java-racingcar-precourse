package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private static final int BASIC_NUM = 4;

    private static final int LIMIT_NUMBER_SIZE = 9;

    private static final String SPLIT_MARK = ",";

    private List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String carNames) {
        getDeviceValue(carNames);
    }

    public Cars() {

    }

    public Cars getDeviceValue(String carNames) {

        String [] array = carNames.split(SPLIT_MARK);
        for(String carNm : array){
            cars.add(new Car(carNm));
        }
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveForward(Cars cars) {
        for(Car car : cars.getCars()){
            if(isGreaterThanCheckValue()){
                car.moveCar();
            }
        }
    }

    public boolean isGreaterThanCheckValue() {
        return getRandomValue() >= BASIC_NUM;
    }

    public int getRandomValue(){
        return (int) (Math.random() * LIMIT_NUMBER_SIZE);
    }
}
