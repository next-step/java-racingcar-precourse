package controller;

import dto.RacerDto;
import entity.Racer;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;

class RacerControllerTest {
    @Test
    @DisplayName("Controller setUpRacer 메소드 성공 테스트")
    void setUpRacerTest() {
        // given
        RacerController controller = new RacerController();

        // when
        ThrowableAssert.ThrowingCallable setUpName = () -> controller.setUpRacer(getValidNameInputString());
        ThrowableAssert.ThrowingCallable setUpNames = () -> controller.setUpRacer(getValidNamesInputString());

        // then
        assertThatCode(setUpName).doesNotThrowAnyException();
        assertThatCode(setUpNames).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Controller setUpRacer 메소드 실패 테스트")
    void setUpRacer_WillThrownTest() {
        // given
        RacerController controller = new RacerController();
        List<String> invalidNameInputStringList = Arrays.asList(null, "   ", "", getInvalidNameInputString());

        for (String invalidNameInputString : invalidNameInputStringList) {
            // when
            ThrowableAssert.ThrowingCallable setUpName = () -> controller.setUpRacer(invalidNameInputString);

            // then
            assertThatThrownBy(setUpName)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(Racer.VALIDATE_NAME_ERROR_MESSAGE);
        }
    }

    @Test
    @DisplayName("Controller setUpGameCount 메소드 성공 테스트")
    void setUpGameCountTest() {
        // given
        RacerController controller = new RacerController();
        BigInteger givenInput = new BigInteger("0");

        // when
        ThrowableAssert.ThrowingCallable setUpGameCount = () -> controller.setUpGameCount(givenInput);

        // then
        assertThatCode(setUpGameCount).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Controller setUpGameCount 메소드 실패 테스트")
    void setUpGameCount_WillThrownTest() {
        // given
        RacerController controller = new RacerController();
        BigInteger givenInput = new BigInteger("-1");

        // when
        ThrowableAssert.ThrowingCallable setUpGameCount = () -> controller.setUpGameCount(givenInput);

        // then
        assertThatThrownBy(setUpGameCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(RacerController.VALIDATE_GAME_COUNT_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("Controller playGame 메소드 성공 테스트")
    void playGameTest() {
        // given
        RacerController controller = new RacerController();
        List<RacerDto> racerDtoList = Arrays.asList(new RacerDto(
                        getValidNameInputString(),
                        BigInteger.ZERO,
                        false
                )
        );

        controller.setUpRacer(getValidNameInputString());
        controller.setUpGameCount(new BigInteger("2"));

        when(RandomNumberGenerator.getRandomNumber(any(int))).thenReturn(3);

        // when
        RacerResult result = controller.playGame();

        // then
        assertThat(result.isEnded()).isEqualTo(false);
        assertThat(result.racers()).isEqualTo(racerDtoList);
    }

    private String getValidNameInputString() {
        return "pobi  ";
    }

    private String getValidNamesInputString() {
        return "pobi,woni    , jun  ";
    }

    private String getInvalidNameInputString() {
        return "pobi, Tester, ";
    }
}
