package racinggame.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racinggame.circuit.FinalRecord;
import racinggame.circuit.Lap;
import racinggame.racingcar.Dice;
import racinggame.racingcar.RacingCar;
import racinggame.circuit.RacingCars;
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
		Lap lap = inputLabs();

		FinalRecord finalRecord = circuit.start(racingCars, lap);

		outputDevice.print("실행결과");
		outputDevice.print(finalRecord.announce());
	}

	private RacingCars makeRacingCars() {
		List<RacingCar> racingCars = new ArrayList<>();

		Dice dice = new Dice(rule.diceMin(), rule.diceMax());

		inputRacingCarNames()
			.forEach(name -> racingCars.add(new RacingCar(name, dice, rule)));

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

	private Lap inputLabs() {
		Lap lap;

		do {
			outputDevice.print("시도할 횟수는 몇회인가요?");
			lap = getLabs(inputDevice.input());
		} while (lap == null);

		return lap;
	}

	private Lap getLabs(String labString) {
		try {
			return new Lap(labString);
		} catch (InvalidNameException | NumberFormatException error) {
			outputDevice.print(error.getMessage());
			return null;
		}
	}
}
