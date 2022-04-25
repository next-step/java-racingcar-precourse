package racingcar.view;

import java.util.List;
import racingcar.domain.dto.CarDto;
import racingcar.domain.dto.CarsDto;

public class ProgressView {

    static final private String GAME_RUNNING_RESULT="실행 결과";

    public static void printProgressStart() {
        System.out.println(GAME_RUNNING_RESULT);
    }

    public static void printProgress(CarsDto carsDto) {
        List<CarDto> cars = carsDto.getCars();
        for (CarDto car : cars) {
            System.out.println(car.getCarName() + " : " + car.getPositionBarString());
        }
    }
}
