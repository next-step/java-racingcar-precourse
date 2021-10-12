package racinggame.racinggame;

import java.util.ArrayList;
import java.util.List;

import racinggame.exception.InvalidNameException;
import racinggame.common.RacingCarName;

public class Names {
	private List<RacingCarName> racingCarNames = new ArrayList<>();

	public void add(RacingCarName racingCarName) {
		if (racingCarNames.contains(racingCarName)) {
			throw new InvalidNameException("[ERROR] 중복된 이름을 사용할 수 없습니다.");
		}
		racingCarNames.add(racingCarName);
	}

	public List<RacingCarName> getNames() {
		return new ArrayList<>(racingCarNames);
	}
}
