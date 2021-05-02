package camp.nextstep.edu.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGameResult {

    private final List<RacingCar> winnerList = new ArrayList<>();
    private int winnerPosition;

    public RacingGameResult(List<RacingCar> racingCarList) {
        setWinnerPosition(racingCarList);
        setWinnerList(racingCarList);
    }

    private void setWinnerPosition(List<RacingCar> racingCarList) {
        List<Integer> positionList = new ArrayList<>();
        for (RacingCar racingCar : racingCarList) {
            positionList.add(racingCar.getPosition());
        }
        winnerPosition = Collections.max(positionList);
    }

    private void setWinnerList(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            addWinner(racingCar);
        }
    }

    public List<RacingCar> getWinnerList() {
        return winnerList;
    }

    private void addWinner(RacingCar racingCar) {
        if (racingCar.getPosition() == winnerPosition) {
            winnerList.add(racingCar);
        }
    }

    @Override
    public String toString() {
        String[] carNames = new String[winnerList.size()];
        for (int i = 0; i < winnerList.size(); i++) {
            carNames[i] = winnerList.get(i).getName();
        }
        return String.format("%s가 최종 우승했습니다.", String.join(",", carNames));
    }
}
