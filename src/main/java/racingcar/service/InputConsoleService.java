package racingcar.service;

import camp.nextstep.edu.missionutils.Console;

public class InputConsoleService implements InputService {

    @Override
    public String getCars() {
        return Console.readLine();
    }

    @Override
    public String getTrack() {
        return Console.readLine();
    }
}
