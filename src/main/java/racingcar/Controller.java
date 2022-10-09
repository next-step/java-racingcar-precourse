package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    Data data = new Data();

    public void nameCheck(String carName){
        List<String> result = new ArrayList<>();
        String temp[] = carName.split(",");

        for(int i = 0; i<temp.length; i++){
            if(temp[i].length() > 5){throw new IllegalArgumentException("이름 5자 초과");}
            if(temp[i].length() <= 0){throw new IllegalArgumentException("이름 없음");}
            result.add(temp[i]);
        }
        data.setCarNameList(result);
    }

    public void tryCountCheck(String count){
        if(!count.matches("[0-9]+")){
            throw new IllegalArgumentException("횟수 설정은 숫자만 가능합니다");
        }
        data.setTryCount(Integer.parseInt(count));
    }

    public void resultRacing(){
        Cars cars = new Cars(makeCar());
        System.out.println(Message.resultInfoString);
        for(int i = 0 ; i < data.getTryCount(); i++){
            runCar(cars);
            System.out.println();
        }

        cars.finalResult();
    }

    public List<Car> makeCar(){
        List<Car> carList = new ArrayList<>();
        for(String name : data.getCarNameList()){
            Car car = new Car(name);
            carList.add(car);
        }
        return carList;
    }

    public void runCar(Cars cars){
        for(Car car : cars.getCarList()){
            int go = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(0, 9);
            if(go >= 4){car.addGo("-");}
        }

        cars.showResult();
    }
}
