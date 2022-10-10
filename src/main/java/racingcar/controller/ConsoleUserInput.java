package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.*;

import racingcar.common.UserString;

/**
 * @author garden.iee
 */
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