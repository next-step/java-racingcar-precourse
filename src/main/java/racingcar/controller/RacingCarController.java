package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarName;
import racingcar.domain.dto.RacingCarDTO;
import racingcar.domain.dto.RacingCarDTOList;
import racingcar.service.RacingCarService;
import racingcar.view.RacingCarView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    private final RacingCarService racingCarService;
    private final RacingCarView racingCarView;

    public RacingCarController(RacingCarService racingCarService, RacingCarView racingCarView) {
        this.racingCarService = racingCarService;
        this.racingCarView = racingCarView;
    }

    public void startRace() {
        RacingCarNamesForm racingCarNames = readRacingCarNamesForm();
        AttemptRaceCountForm raceCount = readAttemptRaceCountForm();

        List<RacingCar> carList = mapRacingCars(racingCarNames);
        racingCarService.save(carList);

        raceAndPrint(raceCount);

        racingCarView.printResult(racingCarService.getWinners());
    }

    private RacingCarNamesForm readRacingCarNamesForm() {
        RacingCarNamesForm racingCarNames;
        while ((racingCarNames = readCarNames()) == null) ;
        return racingCarNames;
    }

    private RacingCarNamesForm readCarNames() {
        RacingCarNamesForm racingCarNames = null;
        try {
            racingCarNames = new RacingCarNamesForm(racingCarView.getRacingCarNames());
        } catch (IllegalArgumentException | IllegalStateException exception) {
            racingCarView.printException(exception);
        }
        return racingCarNames;
    }

    private AttemptRaceCountForm readAttemptRaceCountForm() {
        AttemptRaceCountForm raceCount;
        while ((raceCount = readRaceCount()) == null) ;
        return raceCount;
    }

    private AttemptRaceCountForm readRaceCount() {
        AttemptRaceCountForm raceCount = null;
        try {
            raceCount = new AttemptRaceCountForm(racingCarView.getAttemptRaceCount());
        } catch (IllegalArgumentException exception) {
            racingCarView.printException(exception);
        }
        return raceCount;
    }

    private List<RacingCar> mapRacingCars(RacingCarNamesForm racingCarNames) {
        List<RacingCar> carList = new ArrayList<>();
        for (String racingCarName : racingCarNames.getRacingCarNames()) {
            carList.add(new RacingCar(new RacingCarName(racingCarName)));
        }
        return carList;
    }

    private void raceAndPrint(AttemptRaceCountForm raceCount) {
        for (int i = 0; i < raceCount.getAttemptRaceCount(); i++) {
            List<RacingCar> currentRaceStateCars = racingCarService.race();
            racingCarView.printRace(mapCarListToDto(currentRaceStateCars));
        }
    }

    private RacingCarDTOList mapCarListToDto(List<RacingCar> currentRaceStateCars) {
        List<RacingCarDTO> dtoList = new ArrayList<>();
        for (RacingCar car : currentRaceStateCars) {
            dtoList.add(new RacingCarDTO(car));
        }

        return new RacingCarDTOList(dtoList);
    }
}
