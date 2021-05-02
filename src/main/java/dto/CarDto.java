package dto;

import domain.Distance;

public class CarDto implements Comparable<CarDto> {
    private String name;
    private Distance location;

    public CarDto(String name, Distance location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Distance getLocation() {
        return location;
    }

    @Override
    public int compareTo(CarDto anotherCarDto) {
        return this.location.compareTo(anotherCarDto.getLocation());
    }
}
