package service;

import java.util.ArrayList;
import java.util.List;
import model.RacingCar;

public class GameService {

    public boolean validateCarNames(String inputCarNames) {
        String[] carNames = inputCarNames.split(",");
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        return true;
    }

    public List<RacingCar> createCarList(String inputCarNames) {
        List<RacingCar> carList = new ArrayList<>();
        String[] carNames = inputCarNames.split(",");
        for (String carName : carNames) {
            RacingCar racingCar = new RacingCar(0, carName);
            carList.add(racingCar);
        }

        return carList;
    }

    public boolean validateRounds(int inputRounds) {
        if (inputRounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야합니다.");
        }
        return true;
    }
}
