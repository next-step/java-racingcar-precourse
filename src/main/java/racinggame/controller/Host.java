package racinggame.controller;

import static racinggame.common.CommonConstants.*;

import java.util.Arrays;
import java.util.List;

import racinggame.common.Validator;
import racinggame.domain.Racing;

public class Host {

	Racing racing;

	public Host() {
		racing = new Racing();
	}

	public Racing getRacing() {
		return racing;
	}

	public void setRacingCars(String input) {
		Validator.validInputCarNames(input);
		String[] carNames = input.trim().split(DELIMITER);
		List<String> carNameList = Arrays.asList(carNames);
		racing.joinList(carNameList);
	}

	public void setTryCount(String input) {
		Validator.validTryCount(input);
		racing.setTryCount(Integer.parseInt(input));
	}

	public void start() {
		racing.startRacing();
	}

	public String getRacingResult() {
		return racing.getRacingResults().toString() + NEW_LINE;
	}

	public String getWinner() {
		return racing.getWinner().toString();
	}

}
