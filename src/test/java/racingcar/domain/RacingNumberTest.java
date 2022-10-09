package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.RacingNumber.convertToRacingNumber;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingNumberTest {

    @Test
    void 주어진_숫자만큼_RacingNumber_타입의_리스트_생성() {
        List<RacingNumber> racingNumbers = convertToRacingNumber(Arrays.asList(3,4,5));
        assertThat(racingNumbers.size()).isEqualTo(3);
    }
}