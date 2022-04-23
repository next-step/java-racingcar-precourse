package racingcar.view.output;

import racingcar.domain.Winners;

public class WinnersNameFactory {
    public WinnersName getWinnersName(Winners winners) {
        if (winners.isSoleWinners()) {
            return new SoleWinnersName();
        }

        return new MultiWInnersName();
    }
}
