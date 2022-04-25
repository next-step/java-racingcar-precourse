package racingcar.dto;

import racingcar.domain.Car;

import java.util.List;

public class Result {
    private List<CarDTO> carDTOList;

    public static class CarDTO {
        private String name;
        private int position;

        public CarDTO(String name, int position) {
            this.name = name;
            this.position = position;
        }

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }
    }

    public Result(List<CarDTO> carDTOList) {
        this.carDTOList = carDTOList;
    }

    public List<CarDTO> getCarDTOList() {
        return carDTOList;
    }
}
