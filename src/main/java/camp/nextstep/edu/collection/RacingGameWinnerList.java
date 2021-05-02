package camp.nextstep.edu.collection;

import camp.nextstep.edu.game.RacingCar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGameWinnerList {

    private final List<RacingCar> winnerList = new ArrayList<>();

    public RacingGameWinnerList(List<RacingCar> racingCarList) {
        List<Integer> positionList = new ArrayList<>();
        for (RacingCar racingCar : racingCarList) {
            positionList.add(racingCar.getRacingCarPosition());
        }
        int winnerPosition = Collections.max(positionList);

        setWinnerList(racingCarList, winnerPosition);
    }

    public List<RacingCar> getWinnerList() {
        return winnerList;
    }

    private void setWinnerList(List<RacingCar> racingCarList, int winnerPosition) {
        for (RacingCar racingCar : racingCarList) {
            addWinner(racingCar, winnerPosition);
        }
    }

    private void addWinner(RacingCar racingCar, int winnerPosition) {
        if (racingCar.getRacingCarPosition() == winnerPosition) {
            winnerList.add(racingCar);
        }
    }
}
