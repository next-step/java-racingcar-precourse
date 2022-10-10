package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private final List<RacingCarName> winnerList;

    public Winners(List<RacingCarName> winnerList) {
        this.winnerList = winnerList;
    }

    @Override
    public String toString() {
        List<String> winnerListAsString = new ArrayList<>();
        for (RacingCarName carName : winnerList) {
            winnerListAsString.add(carName.getRacingCarNameValue());
        }

        return String.join(", ", winnerListAsString.toArray(new String[0]));
    }

    public String getWinnersAsString() {
        List<String> winnerListAsString = new ArrayList<>();
        for (RacingCarName carName : winnerList) {
            winnerListAsString.add(carName.getRacingCarNameValue());
        }

        return String.join(", ", winnerListAsString.toArray(new String[0]));
    }
}
