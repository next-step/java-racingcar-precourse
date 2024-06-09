package controller;

import dto.RacerDto;
import dto.RacerResult;
import entity.Racer;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import utils.RandomNumberGenerator;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class RacerControllerTest {
    private RandomNumberGenerator mockRNG = Mockito.mock(RandomNumberGenerator.class);

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
        RandomNumberGenerator generator = mock(RandomNumberGenerator.class);
        RacerController controller = new RacerController();
        List<RacerDto> racerDtoList = List.of(new RacerDto(
                        getValidNameInputString(),
                        BigInteger.ZERO,
                        false
                )
        );

        controller.setUpRacer(getValidNameInputString());
        controller.setUpGameCount(new BigInteger("2"));

        try (MockedStatic<RandomNumberGenerator> generatorMockedStatic = mockStatic(RandomNumberGenerator.class)) {
            given(RandomNumberGenerator.getInstance()).willReturn(generator);

            when(generator.getRandomNumber(anyInt(), anyInt()))
                    .thenReturn(Racer.MOVE_THRESHOLD);

            // when
            RacerResult result = controller.playGame();

            // then
            assertThat(result.isEnded()).isEqualTo(false);
            assertThat(result.racerDtos()).isEqualTo(racerDtoList);
        }
    }

    private String getValidNameInputString() {
        return "pobi";
    }

    private String getValidNamesInputString() {
        return "pobi,woni    , jun  ";
    }

    private String getInvalidNameInputString() {
        return "pobi, Tester, ";
    }
}
