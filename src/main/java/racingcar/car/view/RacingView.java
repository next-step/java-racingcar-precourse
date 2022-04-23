package racingcar.car.view;

import racingcar.car.GameStatus;
import racingcar.car.constant.Constant;
import racingcar.car.constant.MessageConstant;
import racingcar.car.model.dto.CarDTO;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingView {

    public String getInput(GameStatus gameStatus) {
        if (gameStatus == GameStatus.CAR_NAME)
            return getCarNames();
        if (gameStatus == GameStatus.RACING_NUMBER)
            return getRacingNumber();
        return null;
    }

    private String getCarNames() {
        System.out.println(MessageConstant.GUIDE_FOR_INPUT_CARNAME);
        return readLine();
    }

    private String getRacingNumber() {
        System.out.println(MessageConstant.GUIDE_FOR_INPUT_RACINGNUMBER);
        return readLine();
    }

    public void printProgress(ArrayList<CarDTO> cars) {
        for (CarDTO car : cars) {
            printProgressPerCar(car);
        }
        System.out.println();
    }

    private void printProgressPerCar(CarDTO car) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < car.getLocation(); i++)
            stringBuilder.append(Constant.PROGRESS_BAR);
        System.out.println(car.getName() + Constant.PROGRESS_DELIMITER + stringBuilder.toString());
    }

    public void printWinner(ArrayList<CarDTO> cars) {
        ArrayList<String> winnerNames = new ArrayList<>();
        for (CarDTO car : cars) {
            winnerNames.add(car.getName());
        }
        System.out.println(MessageConstant.WINNER_GUIDE + String.join(Constant.WINNER_DELIMITER, winnerNames));
    }

}
