package racinggame;

import static org.assertj.core.api.Assertions.*;
import static racinggame.common.ErrorMessage.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.common.Validator;
import racinggame.controller.Host;
import racinggame.domain.Car;
import racinggame.domain.Racing;

public class HostTest {
	Host host;

	@BeforeEach
	void setUp() {
		host = new Host();
	}

	@Test
	void 레이싱_참가() {
		String input = "pobi,crong,honux";

		host.setRacingCars(input);
		Racing racing = host.getRacing();
		List<Car> carList = racing.getCars().getCarList();

		assertThat(carList)
			.hasSize(3)
			.asString()
			.contains("pobi")
			.contains("crong")
			.contains("honux");
	}

	@Test
	void 레이싱_참가_유효성() {
		String empty = "";

		assertThatThrownBy(()->host.setRacingCars(empty))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_INPUT_NAME);


		String overSize = "123456,안녕하세요,";

		assertThatThrownBy(()->host.setRacingCars(overSize))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_CAR_INPUT_NAME);

	}

	@ParameterizedTest(name = "시도횟수_입력 {0}")
	@ValueSource(strings = {"1","3","4","5"})
	void 시도횟수_입력(String input) {
		host.setTryCount(input);

		int tryCount = Integer.parseInt(input);

		assertThat(host).extracting("tryCount").isEqualTo(tryCount);
	}

	@ParameterizedTest(name = "시도횟수_입력_유효성 {0}")
	@ValueSource(strings = {"011","a","","%%"})
	void 시도횟수_입력_유효성(String input) {
		assertThatThrownBy(() -> host.setTryCount(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_TRY_COUNT);
	}


}
