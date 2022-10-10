package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.InvalidRoundNumberException;
import racingcar.exception.NotContatinNumberException;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("model ( Rounds )")
class RoundsTest {
    private Rounds rounds;
    private GameErrors gameErrors;

    @BeforeEach
    void setUp() {
        gameErrors = new GameErrors();
    }

    @DisplayName("숫자외의 문자가 라운드에 포함되는 경우")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "ㅇㄴㅇㅁㄴ", "abd"})
    @NullAndEmptySource
    void name_contain_special_character_test(String roundNumber) {
        // When && Then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Rounds(roundNumber) )
                        .isInstanceOf(NotContatinNumberException.class)
        );
    }

    @DisplayName("라운드수가 1000라운드를 초과하는 경우")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"1001", "10000", "1000000"})
    void valid_name_length_test(String roundNumber) {
        // When && Then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Rounds(roundNumber) )
                        .isInstanceOf(InvalidRoundNumberException.class)
        );
    }

    @Test
    @DisplayName("라운드수가 최대 int수의 라운드를 초과하는 경우")
    void max_int_size_test() {
        // Given
        String maxRoundNumber;

        // When
        maxRoundNumber = "100000000000000000000000000000000000";

        // Then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new Rounds(maxRoundNumber) )
                        .isInstanceOf(InvalidRoundNumberException.class)
        );
    }

    @DisplayName("라운드수에 올바른 라운드수가 할당되는 경우")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(ints = {1, 99, 100, 999})
    void racing_car_get_name_test(int roundNumber) {
        // when
        rounds = new Rounds(String.valueOf(roundNumber));

        // Then
        assertThat(rounds.getNumber()).isEqualTo(roundNumber);
    }
}