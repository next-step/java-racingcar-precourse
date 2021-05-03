package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import util.GameUtil;

public class CarsTest {
	@Test
	@DisplayName("자동차의 이름이 5자를 초과시 예외 발생 테스트")
	public void validateCarNameLengthWhenOverFiveLengthTest() throws Exception {
		assertThatThrownBy(() -> {
			Cars cars = new Cars(GameUtil.createCars("pobi123,crong,honux"));        // given, when
		}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("자동차의 이름은 5자 이내로 가능합니다.");                    // then
	}
}
