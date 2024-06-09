package domain;

import java.util.ArrayList;

public class CarRepository {
    ArrayList<Car> cars = new ArrayList<>();

    //싱글톤 패턴 적용
    private static CarRepository instance;
    private CarRepository(){};

    public static CarRepository getInstance(){
        if (instance == null){
            instance = new CarRepository();
        }
        return instance;
    }

    public void save(Car car){
        cars.add(car);
    }

    public ArrayList<Car> findAll(){
        return cars;
    }

    public void clear(){
        cars.clear();
    }
}
