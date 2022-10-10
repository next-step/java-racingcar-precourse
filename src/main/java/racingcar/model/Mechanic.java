package racingcar.model;

import racingcar.message.ExceptionMessage;
import racingcar.exception.InvalidRacingCarNameLengthException;
import racingcar.exception.SpecialCharacterContainException;

import java.util.ArrayList;
import java.util.List;

public class Mechanic {
    RacingCarCenter racingCarCenter;

    public void initializingCars(String carNames, GameErrors gameErrors) {
        try {
            giveNameToRacingCars(carNames);
        } catch (Exception e) {
            gameErrors.setDefaultMessage(e.getMessage());
            return;
        }
    }

    public RacingCarCenter getRacingCarCenter() {
        return racingCarCenter;
    }

    private void giveNameToRacingCars(String carNames) throws SpecialCharacterContainException, InvalidRacingCarNameLengthException {
        List<RacingCar> curRacingCars = new ArrayList<>();
        String[] carNameList = carNames.split(",");
        if (carNameList.length == 0) throw new SpecialCharacterContainException(ExceptionMessage.CONTAIN_SPECIAL_CHARACTER_EXCEPTION_MESSAGE);

        for (String carName : carNameList) {
            curRacingCars.add(new RacingCar(carName));
        }
        this.racingCarCenter = new RacingCarCenter(curRacingCars);
    }
}
