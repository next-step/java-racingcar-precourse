package car;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Cars;
import util.GameUtil;

public class CarsTest {
	@Test
	public void validateCarNameLengthTest() throws Exception {
		assertThatThrownBy(() -> {
			Cars cars = new Cars(GameUtil.createCars("pobi123,crong,honux"));        // given, when
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차의 이름은 5자 이내로 가능합니다.");                    // then
	}
}
