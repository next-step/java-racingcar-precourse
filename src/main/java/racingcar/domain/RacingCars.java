package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.strategy.MovingStrategy;
import racingcar.utils.StringUtils;

public class RacingCars {
	private static final String RACING_CAR_NAME_DELIMITER = ",";
	private static final String DUPLICATE_NAME_ERROR_MESSAGE = "중복된 이름이 존재합니다.";
	private static final String DELIMITER_NOT_FOUND_ERROR_MESSAGE = "자동차 이름은 쉼표(,)를 기준으로 구분해주세요.";
	private static final String NAMES_EMPTY_ERROR_MESSAGE = "입력값이 없습니다.";
	private final List<RacingCar> racingCars;

	private RacingCars(List<RacingCar> racingCars) {
		this.racingCars = racingCars;
	}

	public static RacingCars of(String names) {
		validateCarNames(names);
		String[] nameArray = names.split(RACING_CAR_NAME_DELIMITER);
		List<RacingCar> racingCars = generateRacingCars(nameArray);
		return new RacingCars(racingCars);
	}

	private static List<RacingCar> generateRacingCars(String[] nameArray) {
		List<RacingCar> racingCars = new ArrayList<>();
		addRacingCars(nameArray, racingCars);
		return racingCars;
	}

	private static void addRacingCars(String[] nameArray, List<RacingCar> racingCars) {
		for (String name : nameArray) {
			RacingCar racingCar = new RacingCar(name);
			validateDuplicate(racingCars, racingCar);
			racingCars.add(racingCar);
		}
	}

	private static void validateDuplicate(List<RacingCar> racingCars, RacingCar racingCar) {
		if (racingCars.contains(racingCar)) {
			throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
		}
	}

	private static void validateCarNames(String carNames) {
		validateBlank(carNames);
		validateContainDelimiter(carNames);
	}


	private static void validateContainDelimiter(String carNames) {
		if (!carNames.contains(RACING_CAR_NAME_DELIMITER)) {
			throw new IllegalArgumentException(DELIMITER_NOT_FOUND_ERROR_MESSAGE);
		}
	}

	private static void validateBlank(String carNames) {
		if (StringUtils.isBlank(carNames)) {
			throw new IllegalArgumentException(NAMES_EMPTY_ERROR_MESSAGE);
		}
	}

	public List<RacingCar> getRacingCars() {
		return racingCars;
	}

	public void move(MovingStrategy movingStrategy) {
		for (RacingCar racingCar : racingCars) {
			racingCar.move(movingStrategy);
		}
	}

	public Records getRecords() {
		List<Record> recordList = new ArrayList<>();
		for (RacingCar racingCar : racingCars) {
			Record record = Record.from(racingCar);
			recordList.add(record);
		}
		return Records.of(recordList);
	}
}
