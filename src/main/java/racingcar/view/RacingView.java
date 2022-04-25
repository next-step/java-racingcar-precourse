package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.racetrack.FinishLine;
import racingcar.domain.racetrack.RaceTrack;
import racingcar.domain.car.Car;
import racingcar.message.UIMessage;

public class RacingView {

    public static void showMessage(String inputText) {
        System.out.println(inputText);
    }
    
    public static String getCarNameText() {
        showMessage(UIMessage.UI_GET_CAR_NAME);
        return Console.readLine();
    }

    public static String getLapText() {
        showMessage(UIMessage.UI_GET_Lap);
        return Console.readLine();
    }

    public static void showRaceStatus(RaceTrack raceTrack) {
        List<Car> cars = raceTrack.getCars();
        for (Car car : cars) {
            showCarStatus(car);
        }
        showMessage("");
    }

    public static void showCarStatus(Car car) {
        showMessage(car.getName() + " : " + showPosition(car.getPosition().getValue()));
    }

    public static String showPosition(int position) {
        StringBuilder sb = new StringBuilder();
        for (int index = position; index > 0; index--) {
            sb.append("-");
        }
        return sb.toString();
    }

    public static void showWinners(FinishLine finishLine) {
        StringBuilder sb = new StringBuilder(UIMessage.UI_WINNER);
        sb.append(String.join(",", finishLine.getWinnerNames())) ;
        showMessage(sb.toString());
    }
}
