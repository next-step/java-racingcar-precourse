package camp.nextstep.edu.wrapper;

import camp.nextstep.edu.constant.Message;

public class RacingCarName {

    private final String name;

    public RacingCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(Message.INVALID_CAR_NAME);
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
