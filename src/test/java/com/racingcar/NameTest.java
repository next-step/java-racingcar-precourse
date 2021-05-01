package com.racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NameTest {
	@Test
	void 이름_5자_넘는_경우_예외_발생() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Name.of("123456"))
			.withMessage("이름은 5자 이하만 가능합니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "1", "12", "123", "1234", "12345"})
	void 이름_길이가_0_5_사이인_경우_생성_가능(String input) {
		assertThatNoException().isThrownBy(() -> Name.of(input));
	}
}
