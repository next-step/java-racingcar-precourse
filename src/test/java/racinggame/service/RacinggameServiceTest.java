package racinggame.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.message.ErrorMessage;

class RacinggameServiceTest {
	private final RacinggameService racinggameService = new RacinggameService();

	@Test
	void test() {
		assertEquals(0, 0);
		String test = "a";
		System.out.println(test.split(",").length);
	}

	@ParameterizedTest
	@ValueSource(strings = {"a", "a,b", "a,b,c"})
	void 자동차_그룹_생성_시_입력된_자동차_이름과_동일한_개수의_자동차_대수가_그룹에_들어가는지(String carNameInput) {
		assertEquals(carNameInput.split(",").length, racinggameService.createCars(carNameInput).getCarsCount());
	}

	@ParameterizedTest
	@ValueSource(strings = {" ", "a b", "a,b "})
	@EmptySource
	void 자동차_그룹_생성_시_입력값이_빈_값이거나_공백이_포함된_경우_IllegalArgumentException(String carNameInput) {
		assertThrows(IllegalArgumentException.class, () -> {
			racinggameService.createCars(carNameInput);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {" ", "a b", "a,b "})
	@EmptySource
	void 자동차_그룹_생성_시_입력값이_빈_값이거나_공백이_포함된_경우_INVALID_CAR_NAME_INPUT을_메시지로_반환하는지(String carNameInput) {
		try {
			racinggameService.createCars(carNameInput);
		} catch (IllegalArgumentException e) {
			assertEquals(ErrorMessage.INVALID_CAR_NAME_INPUT, ErrorMessage.valueOf(e.getMessage()));
		}
	}
}
