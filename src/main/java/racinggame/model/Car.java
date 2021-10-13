package racinggame.model;

import nextstep.utils.Randoms;
import racinggame.util.Constant;

public class Car {
    private String name;
    private long position;
    private String[] dashes;

    // Constructor
    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    // Getter
    public String getName() {
        return name;
    }

    public long getPosition() {
        return position;
    }

    public String[] getDashes() {
        return dashes;
    }

    // 횟수 받아서 움직임 저장
    public void moveForward(int count, int possibility) {
        dashes = new String[count];
        StringBuilder accumulatedDash = new StringBuilder("");
        for (int i = 0; i < count; i++) {
            move(accumulatedDash,
                    Randoms.pickNumberInRange(Constant.LOWER_BOUND_OF_MOVE_POSSIBILITY, Constant.UPPER_BOUND_OF_MOVE_POSSIBILITY),
                    possibility);
            dashes[i] = accumulatedDash.toString();
        }
    }

    private void move(StringBuilder accumulatedDash, int randVal, int possibility) {
        if (randVal >= possibility) {
            accumulatedDash.append("-");
            position++;
        }
    }
}
