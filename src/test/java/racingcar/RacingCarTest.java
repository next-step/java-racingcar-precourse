package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import camp.nextstep.edu.missionutils.test.NsTest;
import racingcar.util.Constants;

public class RacingCarTest extends NsTest {

    @Nested
    @DisplayName("자동차_이름_유효성_테스트")
    class IsNameValid {

        @Test
        @DisplayName("자동차_이름_5자_이상")
        void isNotOverFiveChars() {
            assertSimpleTest(() -> {
                runException("over5chars,car");
                assertThat(output()).contains(Constants.ERR_1_TO_5_CHAR);
            });
        }

        @Test
        @DisplayName("자동차_이름_null")
        void isNotNull() {
            assertSimpleTest(() -> {
                runException(",");
                assertThat(output()).contains(Constants.ERR_OVER_2_CARS);
            });
        }

        @Test
        @DisplayName("자동차_이름_공백")
        void isNotWhiteSpace() {
            assertSimpleTest(() -> {
                runException(" ,car");
                assertThat(output()).contains(Constants.ERR_1_TO_5_CHAR);
            });
        }
    }

    @Nested
    @DisplayName("전진_회수_유효성_테스트")
    class IsRoundValid {
        @Test
        @DisplayName("입력값_숫자")
        void isNumber() {
            assertSimpleTest(() -> {
                runException("car1,car2", "test");
                assertThat(output()).contains(Constants.ERR_NOT_NUMBER);
            });
        }

        @Test
        @DisplayName("입력값_0")
        void testCharValid() {
            assertSimpleTest(() -> {
                runException("car1,car2", "0");
                assertThat(output()).contains(Constants.ERR_NOT_ZERO);
            });
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
