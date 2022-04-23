package racingcar.util;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilTest extends NsTest {
    private static final int FIRST_RANDOM = 2;
    private static final int SECOND_RANDOM = 9;
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;
    @Test
    @DisplayName("랜덤 수 생성 테스트")
    void createFakeRandomTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    int randomFirst = RandomUtil.create();
                    int randomSecond = RandomUtil.create();
                    assertThat(randomFirst).isEqualTo(FIRST_RANDOM);
                    assertThat(randomSecond).isEqualTo(SECOND_RANDOM);
                },
                FIRST_RANDOM, SECOND_RANDOM
        );
    }

    @RepeatedTest(10)
    @DisplayName("랜덤 수 생성 테스트")
    void createRandomTest() {
        assertRandomNumberInRangeTest(RandomUtil::create,MIN_NUM,MAX_NUM);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}