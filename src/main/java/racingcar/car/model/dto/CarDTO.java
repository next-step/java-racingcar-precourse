package racingcar.car.model.dto;

public class CarDTO {
    private final String name;
    private final int location;

    public CarDTO(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
