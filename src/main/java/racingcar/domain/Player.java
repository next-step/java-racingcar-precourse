package racingcar.domain;

import racingcar.domain.wrap.CarNames;
import racingcar.domain.wrap.TotalRound;

import java.util.List;

import static racingcar.utils.CarNamesUtils.splitByComma;

/**
 * @author : choi-ys
 * @date : 2022/04/22 11:25 오전
 */
public class Player {
    private CarNames carNames;
    private TotalRound totalRound;

    private Player(CarNames carNames, TotalRound totalRound) {
        this.carNames = carNames;
        this.totalRound = totalRound;
    }

    public static Player of(String namesByComma, int totalRound) {
        String[] carNameArray = splitByComma(namesByComma);
        return new Player(CarNames.of(carNameArray), new TotalRound(totalRound));
    }

    public int getTotalRound() {
        return totalRound.getTotalRound();
    }

    public List<String> getCarNames() {
        return carNames.getCarNames();
    }
}
