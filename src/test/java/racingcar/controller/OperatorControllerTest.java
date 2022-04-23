package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.domain.enumtype.InterfaceMsg;
import racingcar.domain.enumtype.ValidationMsg;
import racingcar.service.ValidatorServiceTest;

public class OperatorControllerTest extends NsTest {
	private ValidatorServiceTest validatorServiceTest = ValidatorServiceTest.getInstance();

	@Test
	void string_null_입력_체크() {
		assertEquals(ValidationMsg.NULL_TYPE, validatorServiceTest.getInstance().validationCarName(null));
	}

	@Test
	void string_empty_입력_체크() {
		assertEquals(ValidationMsg.EMPTY_TYPE, validatorServiceTest.getInstance().validationCarName(""));
	}

	@Test
	void 자동차_2대_이상_검증() {
		String carName = "pobi"; final boolean expectFalseMoreThanTwoCar = false;
		String carNames = "pobi,javaji"; final boolean expectTrueMoreThanTwoCar = true;

		boolean isFalseMoreThanTwoCar = validatorServiceTest.isMoreThanTwoCar(carName);
		boolean isTrueMoreThanTwoCar = validatorServiceTest.isMoreThanTwoCar(carNames);

		assertEquals(expectFalseMoreThanTwoCar, isFalseMoreThanTwoCar);
		assertEquals(expectTrueMoreThanTwoCar, isTrueMoreThanTwoCar);
	}

	@Test
	void 자동차_2대_검증_with_IllegalAccessException() {
		assertThrows(IllegalArgumentException.class,() -> {
			System.out.print(InterfaceMsg.REQUEST_INPUT_CAR_NAME.getValue()); run("pobi");
			String carName = readLine(); System.out.println(carName);
			ValidationMsg validationMsg = validatorServiceTest.getInstance().validateCarCount(carName);
			if (validationMsg == ValidationMsg.MORE_THEN_TWO) {
				System.out.println(validationMsg.getValue()); throw new IllegalArgumentException();
			}
		});
	}

	@Test
	void 자동차_이름_길이_유효성_검증() {
		assertThrows(IllegalArgumentException.class,() -> {
			System.out.print(InterfaceMsg.REQUEST_INPUT_CAR_NAME.getValue()); run("pobi,javaji");
			String carName = readLine(); System.out.println(carName);
			ValidationMsg validationMsg = validatorServiceTest.getInstance().validationCarName(carName);
			if (validationMsg == ValidationMsg.CAR_NAME_OVER_FIVE) {
				System.out.println(validationMsg.getValue()); throw new IllegalArgumentException();
			}
		});
	}

	@Test
	void 자동차_이름_중복_검증() {
		assertThrows(IllegalArgumentException.class,() -> {
			System.out.print(InterfaceMsg.REQUEST_INPUT_CAR_NAME.getValue()); run("pobi, pobi");
			String carName = readLine(); System.out.println(carName);
			ValidationMsg validationMsg = validatorServiceTest.getInstance().validationCarName(carName);
			if (validationMsg == ValidationMsg.NOT_DUPLICATE_NAME) {
				System.out.println(validationMsg.getValue()); throw new IllegalArgumentException();
			}
		});
	}

	@Override
	protected void runMain() {

	}
}
