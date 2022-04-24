package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.domain.enumtype.InterfaceMsg;
import racingcar.domain.enumtype.ValidationMsg;
import racingcar.domain.racingcar.RacingCarRepository;
import racingcar.dto.RacingCarDto;
import racingcar.service.ValidatorServiceTest;

public class OperatorControllerTest extends NsTest {
	private ValidatorServiceTest validatorServiceTest = ValidatorServiceTest.getInstance();
	private RacingCarDto racingCarDto;

	@Test
	void 자동차_이름_string_null_입력_체크() {
		assertEquals(ValidationMsg.NULL_TYPE, validatorServiceTest.getInstance().validationCarName(null));
	}

	@Test
	void 자동차_이름_string_empty_입력_체크() {
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
			ValidationMsg validationMsg = validatorServiceTest.getInstance().validationCarName(carName);
			if (validationMsg == ValidationMsg.NEED_MORE_THEN_TWO) {
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

	@Test
	void 자동차_레이싱_시도_회수_string_null_입력_체크() {
		assertEquals(ValidationMsg.NULL_TYPE, validatorServiceTest.getInstance().validationCarRaceTimes(null));
	}

	@Test
	void 자동차_레이싱_시도_회수_string_empty_입력_체크() {
		assertEquals(ValidationMsg.EMPTY_TYPE, validatorServiceTest.getInstance().validationCarRaceTimes(""));
	}

	@DisplayName("자동차_레이싱_시도_회수_입력값_0_검증")
	@Test
	void 자동차_레이싱_시도_회수_입력값_0_검증() {
		assertThrows(IllegalArgumentException.class,() -> {
			System.out.print(InterfaceMsg.REQUEST_INPUT_CAR_RACE_TIMES.getValue()); run("0");
			String carName = readLine(); System.out.println(carName);
			ValidationMsg validationMsg = validatorServiceTest.getInstance().validationCarRaceTimes(carName);
			if (validationMsg == ValidationMsg.ZERO_TYPE) {
				System.out.println(validationMsg.getValue()); throw new IllegalArgumentException();
			}
		});
	}

	@Test
	void 자동차_레이싱_시도_회수_입력값_숫자_이외_값_검증() {
		assertThrows(IllegalArgumentException.class,() -> {
			System.out.print(InterfaceMsg.REQUEST_INPUT_CAR_RACE_TIMES.getValue()); run("pobi");
			String carName = readLine(); System.out.println(carName);
			ValidationMsg validationMsg = validatorServiceTest.getInstance().validationCarRaceTimes(carName);
			if (validationMsg == ValidationMsg.NOT_NUMBER) {
				System.out.println(validationMsg.getValue()); throw new IllegalArgumentException();
			}
		});
	}

	@DisplayName("OperatorControllerTest.repository에_RacingCar_저장()")
	@Test
	void repository에_RacingCar_저장() {
		RacingCarDto racingCarDto = new RacingCarDto("pobi2");
		RacingCarRepository racingCarRepository = new RacingCarRepository();
		racingCarRepository.initSaveRacingCar(racingCarDto);
		assertEquals(racingCarDto.getCarName(), racingCarRepository.getRacingCarByName("pobi2").getCarName());
	}

	@DisplayName("OperatorControllerTest.repository에_RacingCar_저장_후_자동차_전진_또는_정지()")
	@Test
	void repository에_RacingCar_저장_후_자동차_전진_또는_정지() {
		racingCarDto = RacingCarDto.builder().carName("pobi2").build();
		RacingCarRepository racingCarRepository = new RacingCarRepository();
		racingCarRepository.initSaveRacingCar(racingCarDto);
		System.out.println(racingCarRepository.getRacingCarByName(racingCarDto.getCarName()).getCarPosition());
		racingCarRepository.movingForwardByName(racingCarDto);
		System.out.println(racingCarRepository.getRacingCarByName(racingCarDto.getCarName()).getCarPosition());
	}

	@Override
	protected void runMain() {

	}
}
