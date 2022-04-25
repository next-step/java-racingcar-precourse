package racingcar.logic;

import java.util.List;
import java.util.Map;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarGameLogic implements GameLogic {

	@Override
	public boolean process(Object origin, Object value) {
		List<String> racingCarList = (List<String>)origin;
		Map<String, String> racingCarResult = (Map<String, String>)value;

		for (String s : racingCarList) {
			if((Integer)generateNumbers() >= 4){
				racingCarResult.put(s,racingCarResult.get(s) + "-");
			}
		}

		return false;
	}

	@Override
	public Object generateNumbers() {
		return Randoms.pickNumberInRange(1, 9);
	}
}
