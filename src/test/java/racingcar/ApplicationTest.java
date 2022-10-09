package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;
import racingcar.util.Validation;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi,javaji");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    public void 자동차생성_후_원시_포장된_이름_가져오기(){
        RacingCar racingCar = new RacingCar("test");
        assertThat(racingCar.getName()).isEqualTo("test");
    }

    @Test
    public void 이름_다섯자_초과인_자동차_생성시_오류(){
        assertSimpleTest(() ->
            assertThatThrownBy(() -> {
                new RacingCar("12345");
                throw new RuntimeException();
            }).isNotInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
            assertThatThrownBy(() -> {
                new RacingCar("123456");
                throw new RuntimeException();
            }).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    public void 횟수_아닌_값은_오류(){
        assertSimpleTest(() ->
            assertThatThrownBy(() -> {
                Validation.checkRetryCount("-1");
            }).isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
            assertThatThrownBy(() -> {
                Validation.checkRetryCount("1231546879846321357687321");
            }).isInstanceOf(IllegalArgumentException.class)
        );
        assertSimpleTest(() ->
            assertThatThrownBy(() -> {
                Validation.checkRetryCount("asdfas123");
            }).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
