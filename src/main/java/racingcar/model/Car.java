package racingcar.model;

import java.util.Collections;
import racingcar.RacingGameConstants;

public class Car {

    private String name;
    private int moveCount = 0;

    public Car(String name) {
        setName(name);
    }

    public String toString() {
        return String.format("%s : %s", getName(), String.join("", Collections.nCopies(getMoveCount(), "-")));
    }


    public void setName(String name) {
        if (name.length() > RacingGameConstants.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                "[ERROR] 자동차의 이름은 " + RacingGameConstants.MAX_NAME_LENGTH + "자를 넘을 수 없습니다.");
        }
        this.name = name;
    }

    public void setMoveCount(int count) {
        if (!(this.moveCount -1 <= count && count <= this.moveCount + 1)) {
            throw new IllegalArgumentException(
                "[ERROR] 한번에 두 칸 이상 움직일 수 없습니다.");
        }
        if (count < 0) {
            throw new IllegalArgumentException(
                "[ERROR] 뒤로 갈 수 없습니다.");
        }
        this.moveCount = count;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
