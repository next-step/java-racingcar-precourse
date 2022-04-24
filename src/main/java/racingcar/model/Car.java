package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.ValidationUtils;

public class Car {

    private final String name;

    private int position;

    public Car(String name) {
        ValidationUtils.validateCarName(name);
        this.name = name;
        this.position = 0;
    }

    public void doRound() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        doRound(randomNumber);
    }

    public void doRound(int randomNumber) {
        validateRandomNumber(randomNumber);
        if (randomNumber >= 4) {
            forward();
        }
    }

    public void validateRandomNumber(int randomNumber) {
        if (randomNumber < 0 || randomNumber > 9) {
            throw new IllegalArgumentException("랜덤 숫자 범위가 유효하지 않습니다.");
        }
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void forward() {
        this.position++;
    }

    public String getCurrentStatus() {
        StringBuilder status = new StringBuilder(name);
        status.append(" : ");
        for (int i = 1; i <= getPosition(); i++) {
            status.append("-");
        }
        return status.toString();
    }
}
