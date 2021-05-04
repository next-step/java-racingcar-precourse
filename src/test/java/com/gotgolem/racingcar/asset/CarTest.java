package com.gotgolem.racingcar.asset;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

	@DisplayName("자동차 이름 규칙 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"A", "A B", "AAA", "APPLE", "J V M"})
	public void carNameTest(final String carName) {
		assertThatCode(() -> new Car(carName))
				.doesNotThrowAnyException();
		assertThat(new Car(carName).getName())
				.isEqualTo(carName);
	}

	@DisplayName("자동차 생성 실패 테스트")
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"moby-dick", "SIXSIX", "123456", "APPLES", "Oh M Y"})
	public void carNameFailTest(final String carName) {
		assertThatIllegalArgumentException().isThrownBy(() -> new Car(carName));
	}

}
