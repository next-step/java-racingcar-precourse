package racingcar.view;

import racingcar.model.CarNameList;

public class InputCarName extends Input<CarNameList> {
	@Override
	String message() {
		return "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	}

	@Override
	CarNameList generate(String input) {
		return CarNameList.from(input);
	}
}
