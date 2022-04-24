package racingcar.service.dto;

import racingcar.controller.dto.UserInput;
import racingcar.domain.Names;

public class GameInformation {

    private final Names names;
    private final Integer time;

    private GameInformation(Names names, Integer time) {
        this.names = names;
        this.time = time;
    }

    public static GameInformation from(UserInput userInput) {
        Names names = Names.from(userInput.getNames());
        Integer time = Integer.parseInt(userInput.getTimeStr());
        return new GameInformation(names, time);
    }

    public static GameInformation from(String namesStr, Integer time) {
        Names names = Names.from(namesStr);
        return new GameInformation(names, time);
    }

    public Names getNames() {
        return names;
    }

    public Integer getTime() {
        return time;
    }
}
