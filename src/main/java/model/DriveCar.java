package model;

/*
랜덤한 수를 생성해야 함.
랜덤한 수를 각 자동차에 (차이름, "-") 과 같이 dictionary 형태로 저장 ( 이건 CarRacingGame ) 에서 해도 될듯
 */

import java.util.HashMap;
import java.util.Random;

public class DriveCar {
    private Random random = new Random();
    private int go;
    HashMap<String, String> result;

    public DriveCar(HashMap<String, String> result) {
        this.result = result;
    }

    public DriveCar(HashMap<String, String> result, Random random) {
        this.result = result;
        this.random = random;
    }

    public String randomNumber() {
        go = random.nextInt(10);
        if(go >= 4) return "-";
        return "";
    }

    public String randomResult(String go) {
        return go;
    }


    public void drive(String car_name) {
        result.put(car_name, result.get(car_name)+ randomResult(randomNumber()));
    }

}
