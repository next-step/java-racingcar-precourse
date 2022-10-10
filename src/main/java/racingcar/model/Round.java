package racingcar.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Round {
	private final Map<CarName, Progress> carNameProgress;

	private Round(Map<CarName, Progress> carNameProgress) {
		this.carNameProgress = carNameProgress;
	}

	public static Round start(CarNameList carNameList) {
		Map<CarName, Progress> map = new HashMap<>();
		carNameList.getList().forEach(carName -> map.put(carName, Progress.begin()));
		return new Round(map);
	}

	public Round next(CarNameList carNameList) {
		Map<CarName, Progress> map = new HashMap<>();
		carNameList.getList()
			.forEach(carName ->
				map.put(carName, carNameProgress.get(carName).tryForward()));
		return new Round(map);
	}

	public Map<CarName, Progress> getCarNameProgress() {
		return Collections.unmodifiableMap(carNameProgress);
	}

	public Progress getMaxProgress() {
		return Collections.max(carNameProgress.values());
	}
}
