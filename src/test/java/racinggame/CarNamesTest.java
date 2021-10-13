package racinggame;

import static org.assertj.core.api.Assertions.*;
import static racinggame.common.ErrorMessage.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.domain.CarNames;
import racinggame.domain.TryCount;

public class CarNamesTest {

	CarNames carNames;

	@Test
	void 자동차이름들_생성() {
		String names = "자바지기,켄트백,오라클,TDD,우테캠";
		CarNames carNames = new CarNames(names);

		assertThat(carNames.getCarNames())
			.isEqualTo(names);
	}

	@ParameterizedTest(name = "자동차이름들 생성 패턴 유효성 검사 {0}")
	@ValueSource(strings = {"  ", ",하하", "정주나요안정주나요,박명수", "^***,박"})
	void 자동차이름들_생성_패턴검사(String input) {
		assertThatThrownBy(() -> new CarNames(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_INPUT_CAR_NAMES);
	}

	@Test
	void 자동차이름들_생성_중복검사() {
		String input = "LEE,LEE,LEEE";
		assertThatThrownBy(() -> new CarNames(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_DUP_CAR_NAMES);
	}

	@Test
	void 리스트로_반환() {
		CarNames carNames = new CarNames("자바지기,켄트백,오라클,TDD,우테캠");

		List<String> carNameList = carNames.getCarNameList();
		assertThat(carNameList)
			.hasSize(5)
			.containsOnly("자바지기", "켄트백", "오라클", "TDD", "우테캠");
	}

	@ParameterizedTest(name = "시도회수 생성 양수 검사 {0}")
	@ValueSource(ints = {0, -3})
	void 시도회수_숫자_생성_양수검사(int input) {
		assertThatThrownBy(() -> new TryCount(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_TRY_COUNT);
	}

	@ParameterizedTest(name = "시도회수 생성 문자열 검사 {0}")
	@ValueSource(strings = {"a", "^", "0222", "01"})
	void 시도회수_문자열_생성_패턴검사(String input) {
		assertThatThrownBy(() -> new TryCount(input))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage(ERROR_TRY_COUNT);
	}

}
