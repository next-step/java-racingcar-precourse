package camp.nextstep.edu.game;

import camp.nextstep.edu.constant.Message;
import camp.nextstep.edu.wrapper.RacingCarName;
import camp.nextstep.edu.wrapper.RacingCarPosition;

public class RacingCar {

    private final RacingCarName racingCarName;
    private final RacingCarPosition racingCarPosition;

    public RacingCar(String name) {
        racingCarName = new RacingCarName(name);
        racingCarPosition = new RacingCarPosition();
    }

    public String getRacingCarName() {
        return racingCarName.getName();
    }

    public int getRacingCarPosition() {
        return racingCarPosition.getPosition();
    }

    public void move(int number) {
        if (number < 0 || number > 9) {
            throw new IllegalArgumentException(Message.INVALID_MOVE_CONDITION);
        }
        int value = (number >= 4 ? 1 : 0);
        racingCarPosition.setPosition(getRacingCarPosition() + value);
    }

    @Override
    public String toString() {
        String display = new String(new char[getRacingCarPosition()]).replace("\0", "-");
        return String.format("%s : %s", getRacingCarName(), display);
    }
}
