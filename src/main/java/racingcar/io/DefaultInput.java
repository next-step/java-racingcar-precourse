package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class DefaultInput implements Input {

	@Override
	public String getString() {
		return Console.readLine();
	}
}
