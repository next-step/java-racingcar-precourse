package racinggame;

import nextstep.utils.Randoms;

public class RacingGame {
	private final String executionResultMessage = "실행 결과";
	private final int randomMin = 0;
	private final int randomMax = 9;

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/11 12:55 오전
	 * @Description : 게임 시작
	 *
	 **/
	void start() {
		CarInput.init();
		CycleInput.init();

		System.out.println(executionResultMessage);

		for (int i = 0; i < CycleInput.value().cycle(); i++) {
			race();
		}
	}

	/**
	 * @author : yh22953905
	 * @Date : 2021/10/11 12:56 오전
	 * @Description : 경기 시작
	 *
	 **/
	private void race() {
		for (Car car : CarInput.values()) {
			car.distance(Randoms.pickNumberInRange(randomMin, randomMax));
			System.out.println(car);
		}
	}
}
