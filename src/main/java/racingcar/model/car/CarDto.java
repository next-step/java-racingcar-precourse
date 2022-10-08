package racingcar.model.car;

import java.util.List;

public class CarDto {

    private final String name;
    private final List<Boolean> moveRecords;

    public CarDto(Car car) {
        this.name = car.getName();
        this.moveRecords = car.getMoveRecords();
    }

    public String getName() {
        return name;
    }

    public List<Boolean> getMoveRecords() {
        return moveRecords;
    }
}
