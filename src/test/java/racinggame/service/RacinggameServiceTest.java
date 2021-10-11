package racinggame.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.message.ErrorMessage;

class RacinggameServiceTest {
	private final RacinggameService racinggameService = new RacinggameService();

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

	@ParameterizedTest
	@ValueSource(strings = {"", " ", "a"})
	@NullSource
	void 전진_횟수_입력값이_Integer가_아닌_경우_NumberFormatException(String moveCountInput) {
		assertThrows(NumberFormatException.class, () -> {
			racinggameService.validateMoveCountInput(moveCountInput);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {"", " ", "a"})
	@NullSource
	void 전진_횟수_입력값이_Integer가_아닌_경우_INVALID_MOVE_COUNT_INPUT을_메시지로_반환하는지(String moveCountInput) {
		try {
			racinggameService.validateMoveCountInput(moveCountInput);
		} catch (NumberFormatException e) {
			assertEquals(ErrorMessage.INVALID_MOVE_COUNT_INPUT, ErrorMessage.valueOf(e.getMessage()));
		}
	}

	@ParameterizedTest
	@ValueSource(strings = {"0", "-1"})
	void 전진_횟수_입력값이_1보다_작은_경우_IllegalArgumentException(String moveCountInput) {
		assertThrows(IllegalArgumentException.class, () -> {
			racinggameService.validateMoveCountInput(moveCountInput);
		});
	}

	@ParameterizedTest
	@ValueSource(strings = {"0", "-1"})
	void 전진_횟수_입력값이_1보다_작은_경우_INVALID_MOVE_COUNT_INPUT을_메시지로_반환하는지(String moveCountInput) {
		try {
			racinggameService.validateMoveCountInput(moveCountInput);
		} catch (IllegalArgumentException e) {
			assertEquals(ErrorMessage.INVALID_MOVE_COUNT_INPUT, ErrorMessage.valueOf(e.getMessage()));
		}
	}
}
