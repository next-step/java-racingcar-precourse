package camp.nextstep.edu.game;

import camp.nextstep.edu.constant.Message;

public class RacingCar {

    private final String name;
    private int position;

    public RacingCar(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(Message.INVALID_CAR_NAME);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
