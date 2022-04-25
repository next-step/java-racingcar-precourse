package racingcar.service;

import java.util.StringTokenizer;

import camp.nextstep.edu.missionutils.Console;
import racingcar.vo.Car;
import racingcar.vo.Lane;

public class RaceService {

	public Lane prepare() {
		Lane lane;
		String line = Console.readLine();
		StringTokenizer st = new StringTokenizer(line, ",");
		try {
			lane = setting(st);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new Lane();
		}
		return lane;
	}

	private Lane setting(StringTokenizer st) throws Exception {
		Lane lane = new Lane();
		while (st.hasMoreTokens()) {
			String name = st.nextToken().trim();
			if (name == null || "".equals(name)) {
				throw new IllegalArgumentException("[ERROR] : 이름이 입력되지 않았습니다.");
			}
			if (name.length() > 5) {
				throw new IllegalStateException("[ERROR] : 이름이 5자를 초과합니다.");
			}
			lane.enter(new Car(name));
		}
		return lane;
	}

}
