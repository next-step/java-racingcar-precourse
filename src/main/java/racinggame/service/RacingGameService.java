package racinggame.service;

import racinggame.model.CarEntry;
import racinggame.model.GameResult;
import racinggame.model.TryCount;

import java.util.List;

public class RacingGameService {

	private TryCount tryCount;
	private CarEntry carEntry;

	public GameResult runRace() {
		GameResult gameResult = new GameResult();
		while (!tryCount.isZeroCount()) {
			carEntry.race();
			gameResult.addResult(carEntry.getResult());
			tryCount.decreaseCount();
		}
		return gameResult;
	}

	public void initTryCount(int tryCountValue) {
		tryCount = new TryCount(tryCountValue);
	}

	public void initCarList(List<String> carNameList) {
		carEntry = new CarEntry(carNameList);
	}
}
