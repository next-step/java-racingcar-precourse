package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarList;
import racingcar.domain.WinnerRacingCarList;
import racingcar.messenger.ErrorMessage;
import racingcar.messenger.PrintMessage;
import racingcar.messenger.ValidationUtils;

import java.util.Arrays;
import java.util.List;

public class CarMessengerService {

    public List<String> inputCarList() {
        while (true) {
            try {
                String carString = this.input();
                String removeBlankCarString = carString.replace(" ", "");
                List<String> carList = Arrays.asList(removeBlankCarString.split(","));
                ValidationUtils.validateNameLength(carList);
                return carList;
            } catch (IllegalArgumentException e) {
                this.printMessage(ErrorMessage.ERROR.getMessage());
            }
        }
    }

    public int inputMoveNum() {
        while (true) {
            try {
                String moveNum = this.input();
                ValidationUtils.validateMoveNum(moveNum);
                return Integer.parseInt(moveNum);
            } catch (IllegalArgumentException e) {
                this.printMessage(ErrorMessage.ERROR.getMessage());
            }
        }
    }

    private String input() {
        return Console.readLine();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void printMessage(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            String repeat = racingCar.racingCarPosition();
            System.out.printf(PrintMessage.CAR_STATUS.getMessage() + "%n", racingCar.getName(), repeat);
        }
    }

    public void printRacingCarStatus(RacingCarList racingCar) {
        this.printMessage(racingCar.getRacingCarList());
        this.printMessage("--------------------------");
    }

    public void printWinner(WinnerRacingCarList winnerList) {
        String printWinner = winnerList.winnerName();
        this.printMessage(String.format(PrintMessage.WINNER.getMessage(), printWinner));
    }

}
