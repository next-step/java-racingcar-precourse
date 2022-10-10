package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.InvalidRacingCarNameLengthException;
import racingcar.exception.SpecialCharacterContainException;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("model ( RacingCar )")
class RacingCarTest {
    private RacingCar racingCar;
    private GameErrors gameErrors;

    @BeforeEach
    void setUp() {
        this.gameErrors = new GameErrors();
    }

    @DisplayName("특수문자가 이름에 포함되는 경우")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")"})
    @NullAndEmptySource
    void name_contain_special_character_test(String racingCarName) {
        // When && Then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new RacingCar(racingCarName) )
                        .isInstanceOf(SpecialCharacterContainException.class)
        );
    }

    @DisplayName("이름이 5글자를 초과하는 경우")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"123456", "거북이와두루미", "가나다라마바사자차카", "100000000000000000000000000000000000000"})
    void valid_name_length_test(String racingCarName) {
        // When && Then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> new RacingCar(racingCarName) )
                        .isInstanceOf(InvalidRacingCarNameLengthException.class)
        );
    }

    @DisplayName("레이싱카에 올바른 이름이 할당되는 경우")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"phobi", "wony", "jun"})
    void racing_car_get_name_test(String racingCarName) {
        // when
        racingCar = new RacingCar(racingCarName);

        // Then
        assertThat(racingCar.getName()).isEqualTo(racingCarName);
    }


    @Test
    @DisplayName("레이싱카가 앞으로 한칸 이동하는 경우")
    void move_forward_test() {
        // Given
        racingCar = new RacingCar("name");

        // When
        racingCar.moveForward();

        // Then
        assertThat(racingCar.getPosition()).isEqualTo(1);
    }
}