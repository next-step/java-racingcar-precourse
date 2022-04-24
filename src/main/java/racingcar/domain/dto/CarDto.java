package racingcar.domain.dto;

import racingcar.domain.Car;

import java.util.Objects;

public class CarDto {

    private final String name;
    private final int position;

    private CarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarDto from(Car car) {
        return new CarDto(car.getName().getValue(), car.getPosition().getPosition());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarDto carDto = (CarDto) o;
        return Objects.equals(name, carDto.name) && Objects.equals(position, carDto.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }
}

