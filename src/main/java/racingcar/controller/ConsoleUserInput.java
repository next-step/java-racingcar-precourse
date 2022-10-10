package racingcar.controller;

import racingcar.common.UserString;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleUserInput implements UserInput {
    @Override
    public UserString getCarNames() {
        return UserString.of(readLine());
    }

    @Override
    public UserString getRaceCount() {
        return UserString.of(readLine());
    }
}
