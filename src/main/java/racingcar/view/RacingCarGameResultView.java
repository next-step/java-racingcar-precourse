package racingcar.view;

import java.util.List;
import racingcar.vo.RacingCar;
import racingcar.vo.RacingCars;

public class RacingCarGameResultView {

    private static final String MAIN_HEADER = "실행결과";
    private static final String ENTER = "\n";
    private static final String COLON = ":";
    private static final String FORWARD = "-";

    public String allRoundResultView(RacingCars racingCars) {
        StringBuilder resultView = new StringBuilder(MAIN_HEADER).append(ENTER);
        List<RacingCar> racingCarList = racingCars.getRacingCarList();
        int allRound = racingCarList.get(0).getLocationHistory().size();
        for (int round = 0; round < allRound; round++) {
            roundResultView(resultView, racingCarList, round);
            resultView.append(ENTER);
        }
        return resultView.toString();
    }

    private void roundResultView(StringBuilder resultView, List<RacingCar> racingCarList, int round) {
        for (RacingCar racingCar : racingCarList) {
            resultView.append(racingCar.getCarName()).append(COLON);
            int location = racingCar.getLocationHistory().get(round);
            addMoveLocationView(resultView, location);
            resultView.append(ENTER);
        }
    }

    private void addMoveLocationView(StringBuilder resultView, int location) {
        for (int move = 0; move < location; move++) {
            resultView.append(FORWARD);
        }
    }

}
