package racinggame.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import racinggame.circuit.FinalRecord;
import racinggame.circuit.Lap;
import racinggame.racingcar.Dice;
import racinggame.racingcar.Name;
import racinggame.racingcar.RacingCar;
import racinggame.circuit.RacingCars;
import racinggame.exception.InvalidNameException;
import racinggame.rule.WinnerNames;

public final class RacingGame {
	private static final boolean VALID = true;
	private static final boolean INVALID = false;

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

		outputDevice.print(result(finalRecord));
	}

	private String result(FinalRecord finalRecord) {
		WinnerNames winnerNames = rule.judgeWinners(finalRecord);

		return new StringBuilder()
			.append("실행결과\n")
			.append(finalRecord.readFinalRecord())
			.append("최종 우승자는 ")
			.append(winnerNames.getNamesWithDelimiter(","))
			.append(" 입니다.")
			.toString();
	}

	private RacingCars makeRacingCars() {
		List<RacingCar> racingCars = new ArrayList<>();

		Dice dice = new Dice(rule.diceMin(), rule.diceMax());

		inputCarNames().getNames()
			.forEach(name -> racingCars.add(new RacingCar(name, dice, rule)));

		return new RacingCars(racingCars);
	}

	private Names inputCarNames() {
		Names names;
		do {
			outputDevice.print("경주할 자동차 이름을 입력하세요.");
			names = inputRacingCarNames();
		} while (names == null);

		return names;
	}

	private Names inputRacingCarNames() {
		Names names;
		try {
			names = inputNames();
			return names;
		} catch (InvalidNameException e) {
			outputDevice.print(e.getMessage());
			return null;
		}
	}

	private Names inputNames() {
		Names names = new Names();

		String namesChunk = inputDevice.input();
		for (String nameChunk : namesChunk.split(",")) {
			names.add(new Name(nameChunk));
		}

		return names;
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
