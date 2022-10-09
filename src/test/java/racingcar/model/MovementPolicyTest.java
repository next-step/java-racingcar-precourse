package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class MovementPolicyTest {

    private MockedStatic<RandomNumber> randomNumber;


    @BeforeEach
    void beforeEach() {
        this.randomNumber = Mockito.mockStatic(RandomNumber.class);
    }

    @AfterEach
    void afterEach() {
        randomNumber.close();
    }

    @ParameterizedTest(name = "난수 : {0}")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("난수가 4 이상일 경우 전진")
    void move(int randomNumber) {
        // given
        this.randomNumber.when(RandomNumber::generate).thenReturn(randomNumber);

        // then
        assertThat(MovementPolicy.action()).isEqualTo(MovementAction.MOVE);
    }

    @ParameterizedTest(name = "난수 : {0}")
    @ValueSource(ints = {3, 2, 1, 0})
    @DisplayName("난수가 4 미만일 경우 정지")
    void stop(int randomNumber) {
        // given
        this.randomNumber.when(RandomNumber::generate).thenReturn(randomNumber);

        // then
        assertThat(MovementPolicy.action()).isEqualTo(MovementAction.STOP);
    }
}
