package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import racingcar.common.ErrorCode;
import racingcar.common.NaturalNumber;
import racingcar.common.UserString;

/**
 * @author garden.iee
 */
public class RaceGarage {

	private static final int MAX_CAR_COUNT = 20;

	public RaceCars createCars(UserString s) {
		UserString[] carNames = s.split();
		validate(carNames, s);
		return RaceCars.of(getCars(carNames));
	}

	private void validate(UserString[] carNames, UserString userInput) {
		validateUserInputEmptyName(carNames, userInput);
		validateCarNameCount(carNames);
		validateDuplicateName(carNames);
	}

	private void validateUserInputEmptyName(UserString[] carNames, UserString userInput) {
		NaturalNumber count = countDelimitersIn(userInput);
		if (carNames.length == 0 && count.isGreaterThan(NaturalNumber.of(0))) {
			throw new IllegalArgumentException(ErrorCode.ERROR_EMPTY_NAME_IS_EXIST);
		}

		if (!count.isSame(NaturalNumber.of(carNames.length - 1))) {
			throw new IllegalArgumentException(ErrorCode.ERROR_EMPTY_NAME_IS_EXIST);
		}
	}

	private NaturalNumber countDelimitersIn(UserString userInput) {
		int delimiterCount = 0;
		for (int i = 0; i < userInput.length(); i++) {
			delimiterCount += userInput.charAt(i) == ',' ? 1 : 0;
		}
		return NaturalNumber.of(delimiterCount);
	}

	private void validateDuplicateName(UserString[] carNames) {
		if (carNames.length != new HashSet<>(Arrays.asList(carNames)).size()) {
			throw new IllegalArgumentException(ErrorCode.ERROR_CAR_NAME_DUPLICATED);
		}
	}

	private void validateCarNameCount(UserString[] carNames) {
		if (carNames.length > MAX_CAR_COUNT) {
			throw new IllegalArgumentException(
				String.format("%s%s", ErrorCode.ERROR_CAR_COUNT_IS_OVER_MAX_COUNT, MAX_CAR_COUNT));
		}
	}

	private List<Car> getCars(UserString[] userCarNames) {
		List<Car> cars = new ArrayList<>();
		for (UserString carName : userCarNames) {
			cars.add(Car.of(carName));
		}
		return cars;
	}
}