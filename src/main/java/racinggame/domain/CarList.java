package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 일급 컬렉션 활용을 위한 자동차 객체를 저장하는 리스트 Class
 */
public class CarList {
    private final List<Car> carList;

    public CarList(String cars){
        this.carList = new ArrayList<>();
        String[] carArrays = cars.split(",");
        for (String carName : carArrays){
            this.carList.add(new Car(carName));
        }
    }

    public CarList(){
        this.carList = new ArrayList<>();
    }

    public List<Car> getCarList(){
        return this.carList;
    }

    public void addCar(Car car){
        this.carList.add(car);
    }


}
