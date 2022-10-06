package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class Car {

    private final String[] cars;

    public Car(String[] cars) {
        checkCarName(cars);
        checkCarCount(cars);
        this.cars = cars;
    }


    private void checkCarCount(String[] cars) {
        if(cars.length==0){
            throw new IllegalArgumentException("[ERROR] 1개 이상의 이름을 입력하여야 합니다.");
        }
    }

    private void checkCarName(String[] cars) {
        for (String carName : cars){
            checkNameMaxLength(carName);
            checkNameMinLength(carName);
            checkNameUnique(carName,cars);
        }
    }

    private void checkNameMinLength(String carName) {
        if(carName.length()==0){
            throw new IllegalArgumentException("[ERROR] 이름은 1글자 이상이여야합니다.");
        }
    }

    private void checkNameUnique(String carName,String[] cars) {
        if(Collections.frequency(Arrays.asList(cars),carName)>1){
            throw new IllegalArgumentException("[ERROR] 중복된 이름은 입력할 수 없습니다.");
        }
    }

    private void checkNameMaxLength(String carName) {

        if(carName.length()>5){
            throw new IllegalArgumentException("[ERROR] 이름은 5글자 이하여야합니다.");
        }
    }

    public String[] getCars() {
        return cars;
    }
}
