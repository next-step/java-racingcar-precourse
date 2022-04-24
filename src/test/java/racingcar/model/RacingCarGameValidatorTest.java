package racingcar.model;

import org.junit.jupiter.api.*;
import racingcar.common.message.ExceptionMessage;
import racingcar.exception.InvalidCarNameLengthException;
import racingcar.exception.InvalidRacingCarGameRoundsException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarGameValidatorTest {
    private RacingCarGameValidator racingCarGameValidator = new RacingCarGameValidator();
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpOutput() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("정해진 비즈니스 로직을 통과하여 내부 상태값을 변경하는 테스트")
    public void ValidationSuccessTest() {
        // When
        racingCarGameValidator.validationSuccess();

        // Then
        assertThat(racingCarGameValidator.validStatus)
                .isEqualTo(true);
    }

    @Test
    @DisplayName("올바른 자동차 이름을 입력하는 경우(길이 테스트)")
    public void checkRacingCarNameLengthSuccessTest() {
        // Given
        String racingCarName = "pogi";

        // When & Then
        Assertions.assertDoesNotThrow(() -> {
            racingCarGameValidator.checkRacingCarNameLength(racingCarName);
        });
    }

    @Test
    @DisplayName("올바르지 않는 자동차 이름을 입력하는 경우(길이 테스트)")
    public void checkRacingCarNameLengthFailTest() {
        // Given
        String racingCarName = "pdsadsaogi";

        // When & Then
        assertThatThrownBy(() -> racingCarGameValidator.checkRacingCarNameLength(racingCarName))
                .isInstanceOf(InvalidCarNameLengthException.class);
    }

    @Test
    @DisplayName("올바른 자동차 이름들을 입력하는 경우(에러 메시지 발생 x)")
    public void racingCarNamesValidateSuccessTest() {
        // Given
        String racingCarName = "pogi, jiji";

        // When
        racingCarGameValidator.racingCarNamesValidate(racingCarName);

        // Then
        assertThat(output.toString()).doesNotContain(ExceptionMessage.RACING_CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("올바르지 않는 자동차 이름들을 입력하는 경우(에러 메시지 발생)")
    public void racingCarNamesValidateFailTest() {
        // Given
        String racingCarName = "pdsadsaogi";

        // When
        racingCarGameValidator.racingCarNamesValidate(racingCarName);

        // Then
        assertThat(output.toString()).contains(ExceptionMessage.RACING_CAR_NAME_LENGTH_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("올바른 래이싱게임 라운드 값을 입력하는 경우(숫자 유무)")
    public void checkRacingCarGameRoundsIsDigitSuccessTest() {
        // Given
        String racingCarGameRounds = "3";

        // When & Then
        Assertions.assertDoesNotThrow(() -> {
            racingCarGameValidator.checkRacingCarGameRoundsIsDigit(racingCarGameRounds, 0);
        });
    }


    @Test
    @DisplayName("올바르지 않은 래이싱게임 라운드 값을 입력하는 경우(숫자 유무)")
    public void checkRacingCarGameRoundsIsDigitFailTest() {
        // Given
        String racingCarGameRounds = "q";

        // When & Then
        assertThatThrownBy(() -> racingCarGameValidator.checkRacingCarGameRoundsIsDigit(racingCarGameRounds, 0))
                .isInstanceOf(InvalidRacingCarGameRoundsException.class);
    }


    @Test
    @DisplayName("올바른 레이싱게임 라운드를 입력하는 경우(에러 메시지 발생 x)")
    public void racingCarGameRoundsValidateSuccessTest() {
        // Given
        String racingCarGameRounds = "5";

        // When
        racingCarGameValidator.racingCarGameRoundsValidate(racingCarGameRounds);

        // Then
        assertThat(output.toString()).doesNotContain(ExceptionMessage.RACING_CAR_GAME_ROUNDS_EXCEPTION_MESSAGE);
    }

    @Test
    @DisplayName("올바르지 않는 레이싱게임 라운드를 입력하는 경우(에러 메시지 발생)")
    public void racingCarGameRoundsValidateFailTest() {
        // Given
        String racingCarGameRounds = "3q";

        // When
        racingCarGameValidator.racingCarGameRoundsValidate(racingCarGameRounds);

        // Then
        assertThat(output.toString()).contains(ExceptionMessage.RACING_CAR_GAME_ROUNDS_EXCEPTION_MESSAGE);
    }

    @AfterEach
    public void restoreOutput() {
        output.reset();
    }
}