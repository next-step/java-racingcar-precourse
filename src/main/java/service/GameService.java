package service;

import java.util.ArrayList;
import java.util.List;
import model.RacingCar;

public class GameService {

    public boolean validateCarNames(String[] inputCarNames) {
        for (String carName : inputCarNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        return true;
    }

    public List<RacingCar> createCarList(String[] carNames) {
        List<RacingCar> carList = new ArrayList<>();

        for (String carName : carNames) {
            RacingCar racingCar = new RacingCar(0, carName);
            carList.add(racingCar);
        }

        return carList;
    }

}
