package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class RacingResultTest {
    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream(); // OutputStream 생성
        System.setOut(new PrintStream(outputMessage)); // 생성한 OutputStream 으로 설정
    }

    @Test
    @DisplayName("이동거리가 가장 많은 차가 우승한다.")
    void longestDistanceIsWin() {
        // given
        final String RESULT_EXPECTED = "최종 우승자: morp1, morp2";
        final String userInput = "ploy,morp1,morp2,morp3";
        CarNames carNames = CarNames.getCarNamesFromInput(userInput);

        Racing racing = Racing.setRacingCondition(carNames, LapCount.createLapCount("1"));

        MockedStatic<Randoms> mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(1, 4, 4, 2);

        // when
        racing.start();
        mock.close();
        RacingResult racingResult = RacingResult.generateResult(racing);
        racingResult.printResult();

        // then
        String printedMessage = RacingResultTest.outputMessage.toString();
        assertThat(printedMessage.contains(RESULT_EXPECTED)).isTrue();
    }
}
