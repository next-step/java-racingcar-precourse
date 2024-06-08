package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CarManager {
    private Set<Car> carSet;

    private RandomMaker rm;

    public CarManager() {
        this.carSet = new HashSet<Car>();
        this.rm = new RandomMaker();
    }

    /**
     * 새로운 자동차를 추가한다. 자동차 이름은 중복될 수 없다.
     * @param carName
     */
    public void addCar(final String carName){
        Car createCar = new Car(carName);
        if(!carSet.add(createCar)){
            throw new IllegalArgumentException("car 이름이 중복됩니다.");
        };
    }

    /**
     * 레이스를 실행한다.
     */
    public void race(){
        for(Car c : carSet){
            c.doExcel(rm.getRandomValue());
        }
    }

    /**
     * 마지막 레이스의 결과를 얻는다.
     * @return 자동차이름 : 위치
     */
    public Map<String,Integer> getRaceLog(){
        Map<String,Integer> logMap = new HashMap<>();

        for(Car c : carSet){
            logMap.put(c.getName(),c.getPosition());
        }
        return logMap;
    }

}
