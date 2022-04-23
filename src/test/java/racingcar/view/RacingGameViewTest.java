package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class RacingGameViewTest extends NsTest {

    @Test
    @DisplayName("잘못된 이름입력 시 ERROR 메시지가 출력되어야 한다.")
    void proxyTest() {
        assertSimpleTest(() -> {
            runException("abc,abcdefg");
            assertThat(output()).contains(ErrorMessageView.ERROR_MSG);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}