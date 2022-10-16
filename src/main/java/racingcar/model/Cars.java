package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private List<Car> cars=new ArrayList<>();
    public void addCar(Car car) {
        cars.add(car);
    }

    public Cars(){}

    public List<Position> move(MovingStrategy movingStrategy) {
        List<Position> list = new ArrayList<>();
        for(Car car : cars){
            list.add(car.move(movingStrategy));
        }
        return list;
    }

    public Car getCar(int idx){
        return cars.get(idx);
    }
    public int size() {return cars.size();}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }


}
