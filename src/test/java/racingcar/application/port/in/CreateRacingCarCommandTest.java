package racingcar.application.port.in;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RacingCarName;
import racingcar.domain.RacingCarNames;

class CreateRacingCarCommandTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "a,b,", "abcdef,ac", "ab,abcdefg", "a,a"})
    void 예외_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new CreateRacingCarCommand(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"ab,abc", "a,b", "a"})
    void 자동차_이름_반환_테스트(String input) {

        List<RacingCarName> carNameList = Arrays.stream(input.split(",")).map(RacingCarName::new)
                .collect(Collectors.toList());

        RacingCarNames expectedData = new RacingCarNames(carNameList);

        assertEquals(expectedData, new CreateRacingCarCommand(input).getRacingCarNames());
    }
}