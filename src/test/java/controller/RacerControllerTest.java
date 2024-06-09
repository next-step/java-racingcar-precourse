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
    @DisplayName("Controller setUp 메소드 성공 테스트")
    void setUpTest() {
        // given
        RacerController controller = new RacerController();
        BigInteger givenInput = new BigInteger("0");

        // when
        ThrowableAssert.ThrowingCallable setUpName = () -> controller.setUp(getValidNameInputString(), givenInput);

        // then
        assertThatCode(setUpName).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Controller setUp 메소드 숫자로 인한 실패 테스트")
    void setUp_WillThrownByIntegerTest() {
        // given
        RacerController controller = new RacerController();
        BigInteger givenInput = new BigInteger("-1");

        // when
        ThrowableAssert.ThrowingCallable setUp = () -> controller.setUp(getValidNameInputString(), givenInput);

        // then
        assertThatThrownBy(setUp)
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
                        getValidNameInputString().get(0),
                        BigInteger.ZERO,
                        false
                )
        );

        controller.setUp(getValidNameInputString(), new BigInteger("2"));

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

    @Test
    @DisplayName("Controller playGame 메소드에서 게임 종료 테스트")
    void playGameTest_WillEndedTest() {
        // given
        RandomNumberGenerator generator = mock(RandomNumberGenerator.class);
        RacerController controller = new RacerController();
        List<RacerDto> racerDtoList = List.of(new RacerDto(
                getValidNameInputString().get(0),
                        BigInteger.ONE,
                        true
                )
        );

        controller.setUp(getValidNameInputString(), new BigInteger("1"));

        try (MockedStatic<RandomNumberGenerator> generatorMockedStatic = mockStatic(RandomNumberGenerator.class)) {
            given(RandomNumberGenerator.getInstance()).willReturn(generator);

            when(generator.getRandomNumber(anyInt(), anyInt()))
                    .thenReturn(Racer.MOVE_THRESHOLD + 1);

            // when
            RacerResult result = controller.playGame();

            // then
            assertThat(result.isEnded()).isEqualTo(true);
            assertThat(result.racerDtos()).isEqualTo(racerDtoList);
        }
    }

    @Test
    @DisplayName("Controller setUp 없이 playGame 메소드 실행하면 실패하는 테스트")
    void playGameTest_ThrowsExceptionWhenNotSetUp_Test() {
        // given
        RandomNumberGenerator generator = mock(RandomNumberGenerator.class);
        RacerController controller = new RacerController();

        try (MockedStatic<RandomNumberGenerator> generatorMockedStatic = mockStatic(RandomNumberGenerator.class)) {
            given(RandomNumberGenerator.getInstance()).willReturn(generator);

            when(generator.getRandomNumber(anyInt(), anyInt()))
                    .thenReturn(Racer.MOVE_THRESHOLD + 1);

            // when
            ThrowableAssert.ThrowingCallable throwingCallable = controller::playGame;

            // then
            assertThatThrownBy(throwingCallable)
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessage(RacerController.VALIDATE_RACER_LIST_ERROR_MESSAGE);
        }
    }

    @Test
    @DisplayName("Controller playGame 메소드에서 게임 종료 이후 게임을 진행하면 실패하는 테스트")
    void playGameTest_ThrowsExceptionWhenEnded_Test() {
        // given
        RandomNumberGenerator generator = mock(RandomNumberGenerator.class);
        RacerController controller = new RacerController();

        controller.setUp(getValidNameInputString(), new BigInteger("1"));

        try (MockedStatic<RandomNumberGenerator> generatorMockedStatic = mockStatic(RandomNumberGenerator.class)) {
            given(RandomNumberGenerator.getInstance()).willReturn(generator);

            when(generator.getRandomNumber(anyInt(), anyInt()))
                    .thenReturn(Racer.MOVE_THRESHOLD + 1);

            controller.playGame();

            // when
            ThrowableAssert.ThrowingCallable throwingCallable = controller::playGame;

            // then
            assertThatThrownBy(throwingCallable)
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessage(RacerController.VALIDATE_GAME_ENDED_ERROR_MESSAGE);
        }
    }

    private List<String> getValidNameInputString() {
        return List.of("pobi");
    }
}
