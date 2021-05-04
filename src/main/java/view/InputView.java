package view;

import java.io.InputStream;
import java.util.Scanner;

import domain.car.MoveCount;
import domain.car.name.CarNames;

public class InputView {
	public static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String MOVE_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

	private Scanner scanner = null;

	public InputView(InputStream inputStream) {
		scanner = new Scanner(inputStream);
	}

	public CarNames carNames() {
		System.out.println(CAR_NAME_INPUT_MESSAGE);

		return new CarNames(scanner.next());
	}

	public MoveCount inputCount() {
		System.out.println(MOVE_COUNT_INPUT_MESSAGE);

		return new MoveCount(scanner.next());
	}
}
