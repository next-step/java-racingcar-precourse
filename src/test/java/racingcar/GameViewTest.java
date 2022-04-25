package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.TestUtil.FakeConsoleUtil;

public class GameViewTest {

    GameView makeGameViewWithFakeConsoleUtil(String input_string) {
        FakeConsoleUtil fakeConsoleUtil = new FakeConsoleUtil(input_string);

        GameView view = new GameView(fakeConsoleUtil);

        return view;
    }

    @Test
    @DisplayName("5자리이내 자동차 이름이 규칙에 맞는지 검사한다")
    void checkValidCarNames() {
        GameView view = makeGameViewWithFakeConsoleUtil("abc,abcd,abcde");

        CommaSeparatedCarNames car_names = view.readCarNames();

        assertThat(car_names.toString()).isEqualTo("abc,abcd,abcde");
    }

    @Test
    @DisplayName("6자리 자동차 이름이 규칙에 안 맞아 재시도했는지 검사한다")
    void retryReadLineIfNameViolation() {
        GameView view = makeGameViewWithFakeConsoleUtil("abc,abcdef,abcde");

        CommaSeparatedCarNames car_names = view.readCarNames();

        assertThat(car_names.toString()).isEqualTo("0");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1"})
    @DisplayName("0이상 이동 횟수가 규칙에 맞는지 검사한다")
    void checkValidLapCount(String input_lap) {
        GameView view = makeGameViewWithFakeConsoleUtil(input_lap);

        Laps laps = view.readLapCount();

        assertThat(new int[] {0, 1}).contains(laps.getNumericLap());
    }

    @Test
    @DisplayName("음수 이동 횟수가 규칙에 안 맞아 재시도 했는지 검사한다")
    void retryReadLineIfLapCountIsMinus() {
        GameView view = makeGameViewWithFakeConsoleUtil("-1");

        Laps laps = view.readLapCount();

        assertThat(laps.getNumericLap()).isEqualTo(0);
    }
}