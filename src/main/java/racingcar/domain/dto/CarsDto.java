package racingcar.domain.dto;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarsDto {

    private final List<CarDto> carDtos;

    private CarsDto(List<CarDto> carDtos) {
        this.carDtos = carDtos;
    }

    public static CarsDto from(Cars cars) {
        List<CarDto> carDtos = new ArrayList<>();
        for (Car car : cars.getCars()) {
            carDtos.add(CarDto.from(car));
        }
        return new CarsDto(carDtos);
    }

    public List<CarDto> getCarDtos() {
        return carDtos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarsDto carsDto = (CarsDto) o;
        return Objects.equals(carDtos, carsDto.carDtos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carDtos);
    }

    @Override
    public String toString() {
        return "CarsDto{" +
                "carDtos=" + carDtos +
                '}';
    }
}
