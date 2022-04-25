package game.model;

import java.util.HashMap;
import java.util.Map;

//일급 컬렉션 적용
public class RacingCars {
    private final Map<String,Integer> car = new HashMap<>();

    public RacingCars(String carNameList){

        vaildateCarName(carNameList);

    }


    private void vaildateCarName(String carNameList){
        String [] carName = carNameList.trim().split(",");
        for(String name : carName){
            nameLengthCheck(name);
            car.put(name,0);
        }
    }

    //5자 초과된 이름 체크 / 쉼표 후 입력이 없는 이름도 체크(공백인 입력체크)
    private void nameLengthCheck(String name){
        if(name.length() > 5 || name.length() < 1) {
            throw new IllegalArgumentException();
        }
    }

    public Map<String, Integer> getCar() {
        return car;
    }
}
