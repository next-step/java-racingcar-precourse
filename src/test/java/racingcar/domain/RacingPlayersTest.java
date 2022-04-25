package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

/**
 * @author jinyoung
 * @since 2022/04/23
 */
class RacingPlayersTest {

    @Test
    @DisplayName("RacingPlayers: 쉼표가 없는 경우 한 명의 플레이어로 인식 하는지")
    void 쉼표가_없는경우_기능_테스트_RacingPlayers_test() {
        assertEquals(1, new RacingPlayers("young").getRacingPlayers().size());
    }

    @Test
    @DisplayName("RacingPlayers: 쉼표 기준으로 두 명 이상의 플레이어를 인식 하는지")
    void 쉼표로_플레이어_구분하는_기능_테스트_RacingPlayers_test() {
        assertEquals(3, new RacingPlayers("pobi,crong,young").getRacingPlayers().size());
        assertEquals(2, new RacingPlayers("pobi,crong").getRacingPlayers().size());
        assertEquals(4, new RacingPlayers("pobi,crong,makao,obj").getRacingPlayers().size());
    }

    @Test
    @DisplayName("RacingPlayers: 쉼표 기준으로 구분했을 때 5자를 초과하여 입력한 경우 적절한 Exception을 발생시키는지")
    void 쉼표_기준을_구분했을때_5자_초과하는경우_RacingPlayers_test() {
        assertThrowsExactly(IllegalArgumentException.class, () -> new RacingPlayers("pobi,makao1"));
    }

    @ParameterizedTest(name = "RacingPlayers: 빈 값 또는 공백 문자가 입력되는 경우 적절한 Exception을 발생시키는지")
    @NullAndEmptySource
    void 빈값_또는_공백문자_입력하는경우_RacingPlayers_test(String nullOrEmptyUserInput) {
        assertThrowsExactly(IllegalArgumentException.class, () -> new RacingPlayers(nullOrEmptyUserInput));
    }
}
