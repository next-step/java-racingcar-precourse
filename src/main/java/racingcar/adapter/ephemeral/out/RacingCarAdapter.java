package racingcar.adapter.ephemeral.out;

import java.util.ArrayList;
import racingcar.application.port.out.GetRacingCarPort;
import racingcar.application.port.out.SaveRacingCarPort;
import racingcar.domain.RacingCars;

public class RacingCarAdapter implements SaveRacingCarPort, GetRacingCarPort {
    private RacingCars racingCars = new RacingCars(new ArrayList<>());

    @Override
    public void save(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    @Override
    public RacingCars getRacingCars() {
        return racingCars;
    }
}
