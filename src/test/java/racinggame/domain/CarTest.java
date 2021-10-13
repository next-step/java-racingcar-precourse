package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import racinggame.exception.InvalidInputException;

class CarTest {

	@Test
	void 이름은_5글자_이하만_가능하다_정상(){
		String name = "pobi";

		CarName carName = new CarName(name);

		assertThat(carName).isNotNull();
	}

	@Test
	void 이름은_5글자_이하만_가능하다_에러(){
		String name = "sonata";

		assertThatThrownBy(() -> {
			new CarName(name);
		})
		.isInstanceOf(InvalidInputException.class)
		.hasMessage("자동차 이름은 5글자 이하만 가능합니다.")
		;
	}

}