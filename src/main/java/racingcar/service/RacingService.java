package racingcar.service;

import java.util.StringJoiner;
import racingcar.code.ErrorCode;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingService {

    private static final String DASH = "-";
    private static final String SPACE = " ";
    private static final String COLON = ":";
    private static final String CAR_POSITION_RESULT_MIDDLE = SPACE + COLON + SPACE;

    public Cars generateCarsFromUser() {
        try {
            String carNames = InputView.inputCarNames();
            return  Cars.from(carNames);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return generateCarsFromUser();
        }
    }

    public int getGameRounds() {
        try {
            return Integer.parseInt(InputView.inputGameRounds());
        } catch (NumberFormatException e) {
            OutputView.printError(ErrorCode.IS_NOT_NUMBERIC.getErrorMessage());
            return getGameRounds();
        }
    }

    public void processGameRound(Cars cars) {
        cars.moveOrStopCars();
        for (Car car : cars.getCars()) {
            OutputView.printGameRoundResult(getRacingResultStr(car));
        }
    }

    private static String getRacingResultStr(Car car) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(car.getCarName() + CAR_POSITION_RESULT_MIDDLE);
        for (int i = 0; i < car.getPosition(); i++) {
            stringBuffer.append(DASH);
        }
        return stringBuffer.toString();
    }

    public void getGameWinner(Cars cars) {
        OutputView.printGameWinner(generateWinnerStr(cars));
    }

    private String generateWinnerStr(Cars cars) {
        StringJoiner stringJoiner = new StringJoiner(",");
        for (Car maxPositionCar : cars.getMaxPositionCars()) {
            stringJoiner.add(maxPositionCar.getCarName());
        }
        return stringJoiner.toString();
    }

}
