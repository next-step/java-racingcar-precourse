package racingcar.feature;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

public class RacingTest {
    final ByteArrayOutputStream output = new ByteArrayOutputStream();
    MockedStatic<Randoms> randoms;

    @BeforeEach
    public void before() {
        randoms = Mockito.mockStatic(Randoms.class);
        System.setOut(new PrintStream(output));
    }

    @DisplayName("자동차 경주 게임 - 진행")
    @Test
    void racingProgress() {
        //given:
        Racing racing;
        randoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(4);
        //when:
        String input = "test,ming,inni";
        racing = new Racing(input);
        racing.progressAll(new GameCount("1"));
        //then:
        assertEquals("test : -\n"
                        + "ming : -\n"
                        + "inni : -\n\n",
                output.toString());
    }

    @DisplayName("자동차 경주 게임 - 결과")
    @Test
    void racingResult() {
        //given:
        Racing racing;
        randoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(4);
        //when:
        String input = "test,ming,inni";
        racing = new Racing(input);
        racing.printWinner();
        //then:
        assertEquals("최종 우승자: test, ming, inni\n", output.toString());
    }

    @AfterEach
    public void after() {
        randoms.close();
    }
}
