package racingcar.car.service.dto;

import java.util.List;

public class RacingCarPlayerCommand {

    private final List<String> names;
    private final int tryCount;

    public RacingCarPlayerCommand(List<String> names, int tryCount) {
        this.names = names;
        this.tryCount = tryCount;
    }

    public List<String> getNames() {
        return names;
    }

    public int getTryCount() {
        return tryCount;
    }
}
