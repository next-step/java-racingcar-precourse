package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingResultsMap;
import racingcar.utils.RacingCarStringUtils;
import racingcar.utils.RacingCarUtils;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    public Cars getCars(String userInput) {
        validateGetCarsInput(userInput);
        List<Car> carList = new ArrayList<>();
        String[] carNames = userInput.split(",");
        for(String carName : carNames) {
            carList.add(new Car(carName));
        }
        return new Cars(carList);
    }

    private void validateGetCarsInput(String userInput) {
        RacingCarStringUtils.checkNotEmpty(userInput);
        String[] carNames = userInput.split(",");
        RacingCarStringUtils.checkNotDuplicate(carNames);
        RacingCarUtils.checkValidCarNumber(carNames.length);
    }

    public int getTryNumber(String userInput) {
        validateGetTryNumberInput(userInput);
        return Integer.parseInt(userInput);
    }

    private void validateGetTryNumberInput(String userInput) {
        RacingCarStringUtils.checkNotEmpty(userInput);
        RacingCarStringUtils.checkNumberFormat(userInput);
        RacingCarUtils.checkMinTryNumber(Integer.parseInt(userInput));
    }


    public RacingResultsMap race(Cars cars, int tryNumber) {
        return cars.race(tryNumber);
    }

}
