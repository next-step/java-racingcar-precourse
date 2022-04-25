package racingcar;

import racingcar.controller.RaceController;
import racingcar.vo.Lane;
import racingcar.vo.Time;

public class Application {

	public static void main(String[] args) {

		RaceController raceController = new RaceController();
		Lane lane = raceController.prepare();

		TimeController timeController = new TimeController();
		Time time = timeController.prepare();

		raceController.play(lane, time);
		raceController.award(lane);

	}

}
