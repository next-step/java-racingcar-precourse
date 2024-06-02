package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
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

    public int generateCarRandomNum(RacingCar racingCar) {
        Random random = new Random();
        return random.nextInt(10);
    }

    public void determineCarMove(int randomNum, RacingCar racingCar) {
        if (randomNum >= 4) {
            racingCar.setPosition(racingCar.getPosition() + 1);
        }
    }

    public int getMaxPosition(List<RacingCar> racingCars) {
        int maxPosition = 0;

        for (RacingCar car : racingCars) {
            int position = car.getPosition();
            if (position > maxPosition) {
                maxPosition = position;
            }
        }

        return maxPosition;
    }

    public List<String> determineWinner(List<RacingCar> racingCars, int maxPosition) {
        return racingCars.stream()
            .filter(racingCar -> racingCar.getPosition() == maxPosition)
            .map(RacingCar::getCarName)
            .collect(Collectors.toList());
    }
}
