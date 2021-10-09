package racinggame.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racinggame.common.Labs;
import racinggame.racingcar.RacingCar;
import racinggame.common.RacingCars;
import racinggame.common.ResultBoard;
import racinggame.exception.InvalidNameException;

public final class RacingGame {
	private final boolean VALID = true;
	private final boolean INVALID = false;

	private final InputDevice inputDevice;
	private final OutputDevice outputDevice;
	private final Circuit circuit;
	private final Rule rule;

	public RacingGame(InputDevice inputDevice, OutputDevice outputDevice, Circuit circuit, Rule rule) {
		this.inputDevice = inputDevice;
		this.outputDevice = outputDevice;
		this.circuit = circuit;
		this.rule = rule;
	}

	public void play() {
		RacingCars racingCars = makeRacingCars();
		Labs labs = inputLabs();

		ResultBoard resultBoard = circuit.start(racingCars, labs, rule);

		outputDevice.print("실행결과");
		outputDevice.print(resultBoard.read());
	}

	private RacingCars makeRacingCars() {
		List<RacingCar> racingCars = new ArrayList<>();

		inputRacingCarNames()
			.forEach(name -> racingCars.add(new RacingCar(rule, name)));

		return new RacingCars(racingCars);
	}

	private List<String> inputRacingCarNames() {
		String nameChunk;
		do {
			outputDevice.print("경주할 자동차 이름을 입력하세요");
			nameChunk = inputDevice.input();
		} while (checkNameByRule(nameChunk) == INVALID);

		return Arrays.asList(nameChunk.split(","));
	}

	private boolean checkNameByRule(String nameChunk) {
		try {
			rule.validateNames(nameChunk);
		} catch (InvalidNameException error) {
			outputDevice.print(error.getMessage());
			return INVALID;
		}
		return VALID;
	}

	private Labs inputLabs() {
		Labs labs;

		do {
			outputDevice.print("시도할 횟수는 몇회인가요?");
			labs = getLabs(inputDevice.input());
		} while (labs == null);

		return labs;
	}

	private Labs getLabs(String labString) {
		try {
			return new Labs(labString);
		} catch (InvalidNameException | NumberFormatException error) {
			outputDevice.print(error.getMessage());
			return null;
		}
	}
}
