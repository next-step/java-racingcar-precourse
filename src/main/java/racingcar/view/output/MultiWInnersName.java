package racingcar.view.output;

import static racingcar.utils.WordUtils.COMMA;
import static racingcar.utils.WordUtils.FINAL_WINNERS;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Winners;

public class MultiWInnersName implements WinnersName {
    @Override
    public String getWinnersName(Winners winners) {
        List<Car> cars = winners.getWinners();
        StringBuilder winnersName = new StringBuilder();
        for (Car car : cars) {
            winnersName.append(car.getName());
            winnersName.append(COMMA);
        }

        return FINAL_WINNERS + winnersName.substring(0, winnersName.length() - 1);
    }
}
