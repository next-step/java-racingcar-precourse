package racinggame.controller;

import static racinggame.common.CommonConstants.*;

import racinggame.domain.Car;
import racinggame.domain.Racing;

//TODO 벨리데이션 host로 추가
public class Host {

	Racing racing;
	int tryCount;

	public Host() {
		racing = new Racing();
	}

	public Racing getRacing() {
		return racing;
	}

	public void setRacingCars(String input) {
		String[] carNames = input.trim().split(DELIMITER);
		for (String name : carNames) {
			racing.join(new Car(name));
		}
	}

	public void setTryCount(String input) {
		this.tryCount = Integer.parseInt(input);
	}

	public void start() {
		racing.startRacing(tryCount);
	}

	public String getRacingResult() {
		return racing.getRacingResults().toString();
	}

	public String getWinner() {
		return racing.getWinner().toString();
	}

}
