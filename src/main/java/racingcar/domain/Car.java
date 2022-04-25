package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.view.RacingCarOutputView;

public class Car {

    private final int RANDOM_NUMBER = 4;
    private final String CAR_TRACK_DASH = "-";

    private final CarName name;
    private final CarDistance position;

    public Car(String name) {
        this.name = new CarName(name);
        this.position = new CarDistance();
    }

    public String getName() {
        return name.getCarName();
    }

    public int getDistance() {
        return position.getDistance();
    }

    public void runRound() {
        int randomNumber = Randoms.pickNumberInRange(1,9);

        if (isMove(randomNumber)) {
            position.goForward();
        }

        displayCarPosition();
    }

    private boolean isMove(int randomNumber) {
        return randomNumber >= RANDOM_NUMBER;
    }

    private void displayCarPosition() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < getDistance(); i++) {
            sb.append(CAR_TRACK_DASH);
        }
        RacingCarOutputView.outputSeveralResult(getName(), sb.toString());
    }
}
