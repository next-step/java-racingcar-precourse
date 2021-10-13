package racinggame.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingRacingCarNamesTest {
	@DisplayName("콤마(,) 기준으로 파싱 한다")
	@ParameterizedTest
	@ValueSource(strings = {"Red", "Blue"})
	void given_string_then_parse(String name) {
		RacingCarNames inputNames = new RacingCarNames("Red,Blue");
		assertThat(inputNames.parse()).contains(name);
	}
	static List<Arguments> parameters() {
		return Arrays.asList(
			Arguments.of("abcdef,abc,def", "입력 값은 콤마(,)로 구분된 길이 5 이하의 글자 어야 합니다."),
			Arguments.of("Red:Blue", "입력 값은 콤마(,)로 구분된 길이 5 이하의 글자 어야 합니다."),
			Arguments.of("Red,Red", "자동차 이름에 중복이 존재 합니다."),
			Arguments.of(null,"입력 값이 존재 하지 않습니다."),
			Arguments.of("","입력 값이 존재 하지 않습니다."));
	}
}