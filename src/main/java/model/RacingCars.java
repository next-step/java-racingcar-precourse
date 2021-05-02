package model;

import dto.CarRequest;
import dto.CarResponse;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RacingCars {
    private final Map<String, Car> carHash;

    public RacingCars(List<Car> cars) {
        this.carHash = new LinkedHashMap<>();
        cars.forEach(car -> carHash.put(car.getName(), car));
    }

    public CarResponse moveOne(CarRequest carRequest) {
        Car car = carHash.get(carRequest.getCarName());
        car.move(new MoveJudgmentNumber(carRequest.getMoveJudgementNumber()));
        return new CarResponse(car.getName(), car.getPosition());
    }
}
