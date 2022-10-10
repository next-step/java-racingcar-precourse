package racingcar.view;

import racingcar.model.RoundCount;

public class InputRoundCount extends Input<RoundCount> {
	@Override
	String message() {
		return "시도할 횟수는 몇회인가요?";
	}

	@Override
	RoundCount generate(String input) {
		return RoundCount.from(input);
	}
}
