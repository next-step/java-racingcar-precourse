package racingcar.view;

import racingcar.constant.GameMessage;
import racingcar.model.vo.Car;

public class OutputView {

    public void outputResult() {
        System.out.println(GameMessage.OUTPUT_RESULT.getMessage());
    }

    public void outputResultCar(Car car) {
        System.out.println(String.format(
                        GameMessage.OUTPUT_RESULT_CAR
                                .getMessage()
                        , car.getCarName()
                                .getName()
                        , car.getCarPosition()
                                .isPosition()
                )
        );
    }

    public void outputEndGame(String winner) {
        System.out.println(String.format(
                        GameMessage.OUTPUT_WINNER
                                .getMessage()
                        , winner
                )
        );
    }

    public void outputError(Exception e) {
        System.out.println(e.getMessage());
    }
}
