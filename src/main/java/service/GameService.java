package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.RacingCar;

public class GameService {

    public List<RacingCar> getCarNames() {
        Scanner scanner = new Scanner(System.in);
        String[] carNames = new String[0];
        boolean isVallidCarNamesFlag = false;

        while (!isVallidCarNamesFlag) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)로 구분)");
                String userInput = scanner.nextLine();
                carNames = userInput.split(",");
                isVallidCarNamesFlag = isValidCarNames(carNames);
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR" + e);
            }
        }

        return createCarList(carNames);
    }

    private List<RacingCar> createCarList(String[] carNames) {
        List<RacingCar> carList = new ArrayList<>();

        for (String carName : carNames) {
            RacingCar racingCar = new RacingCar(0, 0, carName);
            carList.add(racingCar);
        }

        return carList;
    }

    private boolean isValidCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        return true;
    }
}
