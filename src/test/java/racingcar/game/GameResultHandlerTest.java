package racingcar.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.RaceResult;

class GameResultHandlerTest {
    GameResultHandler sut;

    @BeforeEach
    void setUp() {
        sut = GameResultHandler.create();
    }

    @Test
    void 가장_멀리간_자동차의_이름을_출력한다_단독우승() {
        RaceResult result = mock(RaceResult.class);

        given(result.longestDistance()).willReturn(4);
        given(result.eachCarPosition()).willReturn(getMockCarPosition_단독_우승());

        String message = sut.pickWinner(result);
        assertThat(message).isEqualTo("C");
    }

    @Test
    void 가장_멀리간_자동차의_이름을_출력한다_다중우승() {
        RaceResult result = mock(RaceResult.class);

        given(result.longestDistance()).willReturn(3);
        given(result.eachCarPosition()).willReturn(getMockCarPosition_다중_우승());

        String message = sut.pickWinner(result);
        assertThat(message).isEqualTo("B, C");
    }

    private Map<String, String> getMockCarPosition_단독_우승() {
        Map<String, String> map = new HashMap<>();
        map.put("A", "--");
        map.put("B", "---");
        map.put("C", "----");
        return map;
    }

    private Map<String, String> getMockCarPosition_다중_우승() {
        Map<String, String> map = new HashMap<>();
        map.put("A", "--");
        map.put("B", "---");
        map.put("C", "---");
        return map;
    }
}