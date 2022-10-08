package racingcar.view.result.message;

import racingcar.model.racing.car.RacingCar;
import racingcar.model.racing.car.RacingCarsInGame;

import java.util.ArrayList;

public class CurrentRaceResultResultMessage extends ResultMessage {
    public CurrentRaceResultResultMessage(RacingCarsInGame racingCarsInGame) {
        super(racingCarsInGame);
    }

    @Override
    public String getValue() {
        StringBuilder currentRaceResultStringBuilder = new StringBuilder();
        ArrayList<RacingCar> racingCars = racingCarsInGame.getRacingCars();
        for (RacingCar racingCar : racingCars) {
            currentRaceResultStringBuilder.append(racingCar.getCarName().getValue()).append(" : ");
            int currentAdvance = racingCar.getAdvance().getValue();
            StringBuilder currentAdvanceStringBuilder = new StringBuilder();
            for (int i = 0; i < currentAdvance; ++i) {
                currentAdvanceStringBuilder.append("-");
            }
            currentRaceResultStringBuilder.append(currentAdvanceStringBuilder).append("\n");
        }
        return currentRaceResultStringBuilder.toString();
    }
}
