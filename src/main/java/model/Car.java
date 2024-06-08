package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Car implements Transportation {
    private final String carname;
    private int distance;
    private int distanceUnit;

    public String getCarname() {
        return carname;
    }

    public int getDistance() {
        return distance;
    }

    protected Car(String carname, DistanceUnit distanceUnit) {
        this.carname = carname;
        this.distance = 0;
        this.distanceUnit = distanceUnit.ordinal();

    }
    public Map<String, Integer> run(){
        if(useRandomValues() >=4){
            distance += this.distanceUnit;
        }
        Map<String, Integer> result = new HashMap<>();
        result.put(this.carname, this.distance); // 키(carname)와 값(distance)을 맵에 추가
        return result;
    }

    private int useRandomValues() {
        Random random = new Random();
        int randomInt = random.nextInt(10);
        return randomInt;
    }

}
