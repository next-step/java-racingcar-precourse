package camp.nextstep.edu.game;

import camp.nextstep.edu.collection.RacingGameWinnerList;
import camp.nextstep.edu.constant.Message;

import java.util.List;

public class RacingGameResult {

    private final RacingGameWinnerList racingGameWinnerList;

    public RacingGameResult(List<RacingCar> racingCarList) {
        racingGameWinnerList = new RacingGameWinnerList(racingCarList);
    }

    public List<RacingCar> getWinnerList() {
        return racingGameWinnerList.getWinnerList();
    }

    @Override
    public String toString() {
        String[] carNames = new String[getWinnerList().size()];
        for (int i = 0; i < getWinnerList().size(); i++) {
            carNames[i] = getWinnerList().get(i).getRacingCarName();
        }
        return String.format(Message.WINNER_LIST, String.join(",", carNames));
    }
}
