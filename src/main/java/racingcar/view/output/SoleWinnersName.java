package racingcar.view.output;

import static racingcar.utils.WordUtils.FINAL_WINNERS;
import static racingcar.utils.WordUtils.FIRST_INDEX;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Winners;

public class SoleWinnersName implements WinnersName {
    @Override
    public String getWinnersName(Winners winners) {
        List<Car> cars = winners.getWinners();
        return FINAL_WINNERS + cars.get(FIRST_INDEX).getName();
    }
}
