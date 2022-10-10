package racingcar.presentation;

import racingcar.domain.car.CarName;
import racingcar.domain.car.CarNames;
import racingcar.domain.car.CarPosition;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.String.format;
import static racingcar.presentation.CarViewConstants.*;

public class View {

    public static String getCarsNameAnswer() {
        System.out.println(CAR_NAME_QUESTION);
        return readLine();
    }

    public static String getRoundNumberAnswer() {
        System.out.println(ROUND_NUMBER_QUESTION);
        return readLine();
    }

    public static void printCarNameWithPosition(CarName carName, CarPosition carPosition) {
        StringBuilder carPositionView = new StringBuilder();
        for (int i = 0; i < carPosition.getIntPosition(); i++) {
            carPositionView.append(CAR_POSITION_VIEW);
        }

        System.out.println(format("%s %s %s", carName.getCarName(), COLON, carPositionView.toString()));
    }

    public static void printWinner(CarNames winnerNames) {
        StringBuilder winnerNameBuilder = new StringBuilder();
        for (CarName carName : winnerNames.getCarNames()) {
            winnerNameBuilder.append(carName.getCarName());
            winnerNameBuilder.append(CAR_NAME_SPLITTER);
        }

        System.out.println(format("%s %s %s",WINNER,COLON, removeLastSplitter(winnerNameBuilder.toString())));
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_MESSAGE + errorMessage);
    }

    private static String removeLastSplitter(String winner) {
        return winner.substring(0, winner.length() - 1);
    }

    public static void printResultInformation() {
        System.out.println(GAME_RESULT);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
