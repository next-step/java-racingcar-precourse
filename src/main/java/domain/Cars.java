package domain;

import dto.CarDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars(MovingStrategy movingStrategy) {
        for (Car car : cars) {
            movingStrategy.move(car);
        }
    }

    public List<CarDto> getCarDtos() {
        List<CarDto> carDtos = new ArrayList<>();
        for (Car car : cars) {
            carDtos.add(car.toDto());
        }
        return carDtos;
    }
}
