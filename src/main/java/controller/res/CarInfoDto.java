package controller.res;

import domain.state.CarState;

public class CarInfoDto {
    private final String name;
    private final int position;

    public CarInfoDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public static CarInfoDto toDTO(CarState carState){
        return new CarInfoDto(carState.getName(), carState.getPosition());
    }
}
