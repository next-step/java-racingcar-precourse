package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.ConstantNumber;

public class Car {
    private final Name name;
    private final CarPosition position;

    public Car(Name name) {
        this.name = name;
        this.position = new CarPosition();
    }

    public CarPosition getPosition() {
        return position;
    }

    public Integer getPositionInteger() {
        return position.getPosition();
    }

    public CarPosition move() {
        int randomNumber = Randoms.pickNumberInRange(ConstantNumber.START_INCLUSIVE, ConstantNumber.END_INCLUSIVE);
        GameNumber gameNumber = new GameNumber(randomNumber);
        position.modifyPosition(gameNumber);
        return this.position;
    }

    public String getPositionInDashes() {
        StringBuilder dashes = new StringBuilder();
        for (int i = 0; i < this.position.getPosition(); i++) {
            dashes.append("-");
        }
        return dashes.toString();
    }

    public Name getName() {
        return name;
    }

    public String getNameInString() {
        return name.getValue();
    }
}
