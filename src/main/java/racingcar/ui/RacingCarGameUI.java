package racingcar.ui;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import racingcar.logic.GameLogic;

public class RacingCarGameUI implements GameUI {

	private GameLogic gameLogic;

	public RacingCarGameUI(GameLogic gameLogic) {
		this.gameLogic = gameLogic;
	}

	@Override
	public void process() {

		// Game Start
		List<String> racingCarList = inputRacingCar();

		int tryCount = inputTryCount();

		Map<String, String> racingCarResult = new HashMap<>();

		for (String s : racingCarList) {
			racingCarResult.put(s, "");
		}

		int i = 0;
		while (true) {
			gameLogic.process(racingCarList, racingCarResult);
			for (String s : racingCarResult.keySet()) {
				System.out.println(s + " : " + racingCarResult.get(s));
			}
			System.out.println();
			if (tryCount <= ++i) {
				String result = printResult(racingCarResult);
				System.out.println("최종 우승자 : " + result);
				break;
			}
		}

	}

	@Override
	public boolean end() {

		// 1회만 수행하기 때문에 true
		return true;
	}

	public List<String> inputRacingCar() {
		System.out.println("경주할 자동차 이름을 입력해주세요.(이름은 쉼표(,) 기준으로 구분)");
		List<String> racingCarList = null;
		while (true) {
			try {
				String inputLine = Console.readLine();
				if (inputLine == null || inputLine.length() == 0) {
					throw new IllegalStateException("[ERROR] 입력 상태가 올바르지 않습니다.");
				}
				racingCarList = Arrays.asList(inputLine.split(","));
				Set<String> checkName = new HashSet<>();
				for (String s : racingCarList) {
					if (s.length() > 5)
						throw new IllegalArgumentException("[ERROR] 5자 미만으로 입력 해주세요.");
					checkName.add(s);
				}
				if (checkName.size() != racingCarList.size())
					throw new IllegalArgumentException("[ERROR] 중복되는 이름이 있습니다.");
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return racingCarList;
	}

	public int inputTryCount() {
		System.out.println("시도할 회수");
		int tryCount = 0;
		while (true) {
			try {
				String inputLine = Console.readLine();
				if (inputLine == null || inputLine.length() == 0) {
					throw new IllegalStateException("[ERROR] 입력 상태가 올바르지 않습니다.");
				}
				try {
					tryCount = Integer.parseInt(inputLine);
				} catch (NumberFormatException e) {
					throw new IllegalStateException("[ERROR] 숫자 포맷이 아닙니다.");
				}
				break;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return tryCount;
	}

	private String printResult(Map<String, String> data) {
		String result = null;
		int maxSize = 0;
		for (String s : data.keySet()) {
			if (maxSize < data.get(s).length()) {
				result = s;
				maxSize = data.get(s).length();
			} else if (maxSize == data.get(s).length()) {
				result = result + ", " + s;
			}
		}
		return result;
	}

}
