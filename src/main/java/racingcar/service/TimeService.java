package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.vo.Time;

public class TimeService {

	public Time prepare() {
		Time time;
		String input = Console.readLine();
		try {
			time = setting(input);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new Time(-1);
		}
		return time;
	}

	private Time setting(String input) {
		if (input == null || "".equals(input)) {
			throw new IllegalArgumentException("[ERROR] : 시도할 횟수가 입력되지 않았습니다.");
		}
		if (!input.matches("[0-9]+")) {
			throw new IllegalStateException("[ERROR] : 숫자 이외의 문자가 입력되었습니다.");
		}
		if(Integer.parseInt(input) < 0) {
			throw new IllegalStateException("[ERROR] : 음수가 입력되었습니다.");
		}
		return new Time(Integer.parseInt(input));
	}

}
