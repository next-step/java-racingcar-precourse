package racinggame.view;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Console;
import racinggame.domain.Car;
import racinggame.domain.Cars;
import racinggame.domain.RaceCount;
import racinggame.utils.CollectionUtils;

public final class InputView {
	private static final String INPUT_MESSAGE_OF_CAR_NAMES = "경주할 자동차 이름을 입력해주세요. (이름은 쉽표(,) 기준으로 구분)";
	private static final String INPUT_MESSAGE_OF_RACE_COUNT = "시도할 횟수는 몇회인가요?";
	private static final String EXCEPTION_INVALID_INPUT_MESSAGE_FORMAT = "[ERROR] 잘못된 입력 값입니다. cause: %s\n";
	private static final String DEFAULT_DELIMITER_OF_CAR_NAME = ",";

	private InputView() {
	}

	public static Cars getCars() {
		try {
			System.out.println(INPUT_MESSAGE_OF_CAR_NAMES);
			List<String> carNames = CollectionUtils.toList(Console.readLine(), DEFAULT_DELIMITER_OF_CAR_NAME);
			List<Car> values = new ArrayList<>();
			for (String name : carNames) {
				values.add(new Car(name));
			}
			return new Cars(values);
		} catch (IllegalArgumentException e) {
			System.err.format(EXCEPTION_INVALID_INPUT_MESSAGE_FORMAT, e.getMessage());
			return getCars();
		}
	}

	public static RaceCount getRaceCount() {
		try {
			System.out.println(INPUT_MESSAGE_OF_RACE_COUNT);
			int value = Integer.parseInt(Console.readLine());
			return new RaceCount(value);
		} catch (IllegalArgumentException e) {
			System.err.format(EXCEPTION_INVALID_INPUT_MESSAGE_FORMAT, e.getMessage());
			return getRaceCount();
		}
	}
}