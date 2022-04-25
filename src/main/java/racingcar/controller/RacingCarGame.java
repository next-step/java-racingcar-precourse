package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.PlayCount;
import racingcar.dto.Result;
import racingcar.ui.Input;
import racingcar.ui.Output;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private CarList carList;
    private PlayCount playCount;

    public void start() {
        do {
            receiveCarNames();
        }while (carList == null);
        do {
            receivePlayCount();
        }while (playCount == null);

        repeatRace(playCount, carList);
        printLastResult(carList.getWinner());
    }

    private void receiveCarNames() {
        try {
            String inputCarNames = Input.receiveCarNames();
            this.carList = CarList.createCarList(inputCarNames);
        } catch (IllegalArgumentException e) {
            Output.printError(e);
        }
    }
    private void receivePlayCount () {
        try {
            String inputPlayCount = Input.receiveCount();
            this.playCount = new PlayCount(inputPlayCount);
        } catch (IllegalArgumentException e) {
            Output.printError(e);
        }
    }

    private void repeatRace(PlayCount playCount, CarList carList) {
        for (int i = 0; i < playCount.getPlayCount(); i++) {
            carList.play();
            printCurrentResult(carList);
        }
    }

    private void printCurrentResult(CarList carList) {
        List<Result.CarDTO> dtoList = new ArrayList();
        for (Car car : carList.getCarList()) {
            dtoList.add(new Result.CarDTO(
                    car.getName(),
                    car.getPosition()
            ));
        }
        Result result = new Result(dtoList);
        Output.printCurrentResultPrefix();
        Output.printCurrentResult(result);
    }

    private void printLastResult(List<Car> winnerCarList) {
        ArrayList<String> winnerNameList = new ArrayList();
        for (Car car: winnerCarList) {
            winnerNameList.add(car.getName());
        }

        Output.printLastResult(String.join(",", winnerNameList));
    }
}
