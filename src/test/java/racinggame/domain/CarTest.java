package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.exception.ErrorMessage;
import racinggame.exception.InvalidInputException;

class CarTest {

	@ParameterizedTest
	@ValueSource(strings = {"pobi", "a"})
	void 이름은_5글자_이하만_가능하다_정상(String name){

		CarName carName = new CarName(name);

		assertThat(carName).isNotNull();
	}

	@ParameterizedTest
	@ValueSource(strings = {"sonata", ""})
	void 이름은_5글자_이하만_가능하다_에러(String name){

		assertThatThrownBy(() -> {
			new CarName(name);
		})
		.isInstanceOf(InvalidInputException.class)
		.hasMessage(ErrorMessage.CAR_NAME_MAX_LENGTH.getMessage())
		;
	}

}