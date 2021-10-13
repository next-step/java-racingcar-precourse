package racinggame.view;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Console;
import racinggame.CarName;
import racinggame.CarNames;
import racinggame.PlayCount;

public class InputView {
	private static String input(String requestMessage) {
		System.out.println(requestMessage);
		return Console.readLine();
	}

	public static CarNames inputCarNames() {
		CarNames result = null;
		while (result==null) {
			String inputCarNames = input("경주할 자동차 이름을 입력하세요.(이름은 쉼포(,) 기준으로 구분)");
			result = getValidatedCarNames(inputCarNames);
		}

		return result;
	}

	private static CarNames getValidatedCarNames(String inputCarNames) {
		try {
			return mapToCarNames(inputCarNames);
		} catch (Exception e) {
			OutputView.outputError(e.getMessage());
			return null;
		}
	}

	private static CarNames mapToCarNames(String inputCarNames) {
		String[] arr = inputCarNames.split(",");

		List<CarName> carNames = new ArrayList<>();
		for (String str : arr) {
			carNames.add(new CarName(str));
		}

		return new CarNames(carNames);
	}

	public static PlayCount inputCount() {
		PlayCount result = null;
		while (result==null) {
			String inputCount = input("시도할 회수는 몇회인가요?");
			result = getValidatedCount(inputCount);
		}

		return result;
	}

	private static PlayCount getValidatedCount(String inputCount) {
		try {
			return mapToCount(inputCount);
		} catch (NumberFormatException nfe) {
			OutputView.outputError("숫자만 입력 가능합니다");
		} catch (Exception e) {
			OutputView.outputError(e.getMessage());
		}
		return null;
	}

	private static PlayCount mapToCount(String inputCount) {
		int count = Integer.parseInt(inputCount);
		return new PlayCount(count);
	}
}
