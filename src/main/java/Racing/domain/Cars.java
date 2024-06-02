package Racing.domain;


import java.util.ArrayList;
import java.util.List;

public class Cars {

    //자동차들의 정보를 가지는 Cars 도메인.
    private List<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }


    public void setCars(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

}
