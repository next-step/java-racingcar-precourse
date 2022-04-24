package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.vo.RacingCar;
import racingcar.vo.RacingCars;

public class RacingCarGameResultView {

    private static final String MAIN_HEADER = "실행결과";
    private static final String ENTER = "\n";
    private static final String COLON = ":";
    private static final String FORWARD = "-";
    private static final String COMMA = ",";
    private static final String GAP = " ";
    private static final String WINNERS_MAIN_HEADER = "최종우승자";

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

    public String racingGameWinnersView(List<RacingCar> gameWinnerList) {
        StringBuilder winnersView = new StringBuilder(WINNERS_MAIN_HEADER).append(COLON).append(GAP);
        List<String> winnerNameList = extractedWinnerNameList(gameWinnerList);
        winnersView.append(String.join(COMMA,winnerNameList));
        return winnersView.toString();
    }

    private List<String> extractedWinnerNameList(List<RacingCar> gameWinnerList) {
        List<String> winnersNameList = new ArrayList<>();
        for(RacingCar racingCar : gameWinnerList){
            winnersNameList.add(racingCar.getCarName());
        }
        return winnersNameList;
    }
}
