package Racing.service;

import Racing.domain.Car;
import Racing.domain.Cars;
import java.util.List;

public class GenerateCarService {

    //자동차를 이름으로 처음 생성(초기화). 이동한 거리는 0인 상태.
    public Cars generate(List<String> carName){
        Cars cars = new Cars();
        for(String s : carName){
            Car c = new Car(s);
            cars.setCars(c);
        }
        return cars;

    }


}
