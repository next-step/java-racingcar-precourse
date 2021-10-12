package racinggame.rule;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.exception.InvalidNameException;
import racinggame.rule.winnerrules.FarAwayWinRule;
import racinggame.ui.Rule;

class RacingRuleTest {

	private Rule rule;

	@BeforeEach
	void beforeEach() {
		rule = RacingRuleConfig.rule();
	}

	@DisplayName("입력 성공")
	@ParameterizedTest
	@ValueSource(strings = {"a,ab,abc,abcd,abcde"})
	void nameSuccess(String name) {
		assertThatNoException()
			.isThrownBy(() -> rule.validateNames(name));
	}

	@DisplayName("에러발생 - 제한 길이 미만, 초과")
	@ParameterizedTest
	@ValueSource(strings = {",abcdef,abcdefg"})
	void nameLengthFail(String name) {
		assertThatThrownBy(() -> rule.validateNames(name))
			.isInstanceOf(InvalidNameException.class)
			.hasMessage("[ERROR] 이름을 1자 이상 5자 이하로 입력하세요");
	}

	@DisplayName("에러발생 - 이름 중복")
	@ParameterizedTest
	@ValueSource(strings = {"abc,abc,abc"})
	void nameDuplicatedFail(String name) {
		assertThatThrownBy(() -> rule.validateNames(name))
			.isInstanceOf(InvalidNameException.class)
			.hasMessage("[ERROR] 중복된 이름을 사용할 수 없습니다.");
	}

	static class RacingRuleConfig {
		static Rule rule (){
			return new RacingRule(winner());
		}

		static WinnerDecisionRule winner() {
			return new FarAwayWinRule();
		}
	}
}