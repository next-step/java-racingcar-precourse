package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class RandomNumTest extends NsTest {
    @Test
    void RandomNum_값_유효성_테스트() {
        for (int i = 0; i < 100; i++) {
            int randomNum = new RandomNum().getRandomNum();
            assertThat(randomNum >= 1 && randomNum < 10).isTrue();
        }

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
