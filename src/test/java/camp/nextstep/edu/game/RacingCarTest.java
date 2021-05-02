package camp.nextstep.edu.game;

import camp.nextstep.edu.constant.Message;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingCarTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcde", "가나다라마", "12345"})
    @DisplayName("레이싱카 생성 - 성공 테스트")
    void newRacingCar_successTest(String name) {
        // given & when
        RacingCar car = new RacingCar(name);

        // then
        assertThat(car.getRacingCarName()).isEqualTo(name);
        assertThat(car.getRacingCarPosition()).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "가나다라마바", "123456"})
    @DisplayName("레이싱카 생성 - 실패 테스트")
    void newRacingCar_failureTest(String name) {
        // given & when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingCar(name))
                .withMessageContaining(Message.INVALID_CAR_NAME);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    @DisplayName("레이싱카 전진/멈춤 - 성공 테스트")
    void racingCar_move_successTest(int generatedNumber, int expectedPosition) {
        // given
        RacingCar car = new RacingCar("test");

        // when
        car.move(generatedNumber);

        // then
        assertThat(car.getRacingCarPosition()).isEqualTo(expectedPosition);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "10"})
    @DisplayName("레이싱카 전진/멈춤 - 실패 테스트")
    void racingCar_move_failureTest(int generatedNumber) {
        // given & when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingCar("test").move(generatedNumber))
                .withMessageContaining(Message.INVALID_MOVE_CONDITION);
    }
}
