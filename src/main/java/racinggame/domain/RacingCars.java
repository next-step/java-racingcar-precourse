package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import racinggame.utils.Message;
import racinggame.utils.MessageBuilder;

public class RacingCars {
    private static final String CAR_NAME_SEPARATOR = ",";

    private final List<RacingCar> racingCarList;

    public RacingCars(String carsStr) {
        racingCarList = new ArrayList<>();
        String[] carNames = carsStr.split(CAR_NAME_SEPARATOR);

        for (String carName : carNames) {
            racingCarList.add(new RacingCar(new CarName(carName)));
        }
    }

    public int getSize() {
        return racingCarList.size();
    }

    public void moveForwardOrStop() {
        for (int idx = 0; idx < racingCarList.size(); idx++) {
            moveForwardOrStop(idx, MoveStatus.createRandom());
        }
    }

    void moveForwardOrStop(int idx, MoveStatus moveStatus) {
        racingCarList.get(idx).moveForwardOrStop(moveStatus);
    }

    public Winners findWinners() {
        Step maxStep = Collections.max(racingCarList, Comparator.comparing(RacingCar::getStep)).getStep();

        List<CarName> winners = new ArrayList<>();
        for (RacingCar racingCar : racingCarList) {
            addIfMaxStep(winners, maxStep, racingCar);
        }

        return new Winners(winners);
    }

    private void addIfMaxStep(List<CarName> winners, Step maxStep, RacingCar racingCar) {
        if (racingCar.getStep().equals(maxStep)) {
            winners.add(racingCar.getCarName());
        }
    }

    public Message makeResultMessage() {
        MessageBuilder messageBuilder = new MessageBuilder();
        for (RacingCar racingCar : racingCarList) {
            messageBuilder.append(racingCar.makeStatusMessage()).appendNewLine();
        }

        return messageBuilder.toMessage();
    }
}
