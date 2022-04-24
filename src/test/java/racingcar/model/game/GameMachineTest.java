package racingcar.model.game;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static racingcar.view.SystemOutputErrorView.ERROR_PREFIX;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.Application;
import racingcar.config.CarMovingConfig;

class GameMachineTest extends NsTest {

    @BeforeEach
    void 초기값_셋팅() {
        CarMovingConfig.RACING_CAR_MOVING_RANGE_VALUE_MIN = 0;
        CarMovingConfig.RACING_CAR_MOVING_RANGE_VALUE_MAX = 9;
        CarMovingConfig.RACING_CAR_MOVING_STANDARD_VALUE = 4;
    }

    @ParameterizedTest
    @DisplayName("게임 설정값 유효성 검사")
    @CsvSource(value = {"6:6:6", "1:9:0", "0:8:9"}, delimiter = ':')
    void 게임_설정값_체크(int minValue, int maxValue, int standardValue) {

        CarMovingConfig.RACING_CAR_MOVING_RANGE_VALUE_MIN = minValue;
        CarMovingConfig.RACING_CAR_MOVING_RANGE_VALUE_MAX = maxValue;
        CarMovingConfig.RACING_CAR_MOVING_STANDARD_VALUE = standardValue;

        assertThatIllegalStateException().isThrownBy(GameMachine::new);
    }

    @Test
    @DisplayName("시도할 횟수가 음수, 문자일 때 재입력값 처리")
    void 시도할_횟수가_음수_혹은_문자일_때_재입력값_처리() {
        assertSimpleTest(
            () -> {
                runException("pobi,test", "-1", "test", "1");
                assertThat(output())
                    .contains(ERROR_PREFIX + "시도할 횟수는 양수이어야 합니다.", ERROR_PREFIX + "시도 횟수는 숫자여야 합니다.");
            }
        );
    }

    @Test
    @DisplayName("우승자가 여러명일 경우 출력 확인")
    void 우승자가_여러명일_경우_출력_확인() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "2");
                assertThat(output()).contains("pobi : -", "woni : -", "pobi : --", "woni : --", "최종 우승자: pobi, woni");
            },
            CarMovingConfig.RACING_CAR_MOVING_STANDARD_VALUE, CarMovingConfig.RACING_CAR_MOVING_STANDARD_VALUE
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
