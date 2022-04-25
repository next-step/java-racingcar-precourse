package racingcar;

import racingcar.service.TimeService;
import racingcar.vo.Time;

public class TimeController {

	private TimeService service;

	public TimeController() {
		this.service = new TimeService();
	}

	public Time prepare() {
		Time time = new Time();
		do {
			System.out.println("시도할 횟수는 몇회인가요?");
			time = service.prepare();
		} while (time.getValue() == -1);
		return time;
	}

}
