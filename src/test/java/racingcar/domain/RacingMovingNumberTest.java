package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

/**
 * @author jinyoung
 * @since 2022/04/23
 */
public class RacingMovingNumberTest {

    @Test
    @DisplayName("RacingMovingNumber: 입력 받은 숫자 검증: 숫자 0 또는 숫자가 아닌 문자열을 입력하는 경우 적절한 Exception을 발생시키는지")
    void 숫자0_또는_문자열입력하는경우_RacingMovingNumber_test() {
        assertThrowsExactly(IllegalArgumentException.class, () -> new RacingMovingRound("0"));
        assertThrowsExactly(IllegalArgumentException.class, () -> new RacingMovingRound("a"));
        assertThrowsExactly(IllegalArgumentException.class, () -> new RacingMovingRound("@#!@"));
    }

    @ParameterizedTest(
            name = "RacingMovingNumber: 입력 받은 숫자 검증: 빈 값 또는 공백 문자가 입력되는 경우 적절한 Exception을 발생시키는지")
    @NullAndEmptySource
    void 빈값_또는_공백문자_입력하는경우_RacingMovingNumber_test(String nullOrEmptyUserInput) {
        assertThrowsExactly(IllegalArgumentException.class, () -> new RacingMovingRound(nullOrEmptyUserInput));
    }
}
