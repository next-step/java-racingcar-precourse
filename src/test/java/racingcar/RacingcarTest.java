package racingcar;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingcarTest {
    @ParameterizedTest
    @ValueSource(strings = {"람보르기니", "페라리,포르쉐"})
	@DisplayName("자동차 이름을 입력받아 Cars객체를 생성하는 테스트")
	public void 자동차_리스트_입력받기(String names) {
		assertTrue(new Racingcar().initCars(names));
	}

    @ParameterizedTest
    @ValueSource(strings = {"", ",페라리,포르쉐", "람보르기니한정판","페라리,포르쉐,","페라리,,포르쉐"})
	@DisplayName("자동차 이름을 입력을 실패하는 테스트")
	public void 자동차_리스트_입력받기_예외(String names) {
		assertFalse(new Racingcar().initCars(names));
	}

    @ParameterizedTest
    @ValueSource(strings = {"aa", "-1", "0", "*0"})
	@DisplayName("게임 반복횟수를 입력을 실패하는 테스트")
	public void 게임_반복횟수_입력받기_예외(String round) {
		assertFalse(new Racingcar().play(round));
	}
    
    @ParameterizedTest
    @ValueSource(strings = {"1", "3"})
	@DisplayName("게임 반복횟수를 입력을 실패하는 테스트")
	public void 게임_반복횟수_입력받기(String round) {
		assertTrue(new Racingcar().initCars(round));
	}
}
