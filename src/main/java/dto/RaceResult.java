package dto;

import model.Car;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {
    private final List<CarResponse> responses;

    public RaceResult(List<Car> cars) {
        this.responses = new ArrayList<>();
        cars.forEach(car -> responses.add(new CarResponse(car.getName(), car.getPosition())));
    }

    public List<CarResponse> getResponses() {
        return responses;
    }
}
