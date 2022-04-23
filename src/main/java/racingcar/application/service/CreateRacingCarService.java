package racingcar.application.service;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import racingcar.application.port.in.CreateRacingCarCommand;
import racingcar.application.port.in.CreateRacingCarUsecase;
import racingcar.application.port.out.SaveRacingCarPort;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarName;
import racingcar.domain.RacingCarNames;
import racingcar.domain.RacingCars;

@AllArgsConstructor
public class CreateRacingCarService implements CreateRacingCarUsecase {
    private final SaveRacingCarPort saveRacingCarPort;

    @Override
    public void create(CreateRacingCarCommand command) {
        List<RacingCar> racingCarList = new ArrayList<>();
        RacingCarNames racingCarNames = command.getRacingCarNames();

        for (RacingCarName name : racingCarNames.getNames()) {
            racingCarList.add(new RacingCar(name));
        }

        saveRacingCarPort.save(new RacingCars(racingCarList));
    }
}
