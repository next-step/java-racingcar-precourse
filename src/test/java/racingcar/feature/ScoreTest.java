package racingcar.feature;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;

public class ScoreTest {
    MockedStatic<Randoms> randoms;

    @BeforeEach
    public void before() {
        randoms = Mockito.mockStatic(Randoms.class);
    }

    @DisplayName("점수 - 점수 생성")
    @Test
    public void createScoreTest() {
        //given:
        Score score = new Score();
        //when:
        //then:
        assertThat(score.getScoreCount())
                .isEqualTo(0);
    }

    @DisplayName("점수 - 전진")
    @Test
    public void advanceTest() {
        //given:
        randoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(4);
        Score score = new Score();
        //when:
        score.stopOrAdvance();
        //then:
        assertThat(score.getScoreCount())
                .isEqualTo(1);
    }

    @DisplayName("점수 - 멈춤")
    @Test
    public void stopTest() {
        //given:
        randoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(3);
        Score score = new Score();
        //when:
        score.stopOrAdvance();
        //then:
        assertThat(score.getScoreCount())
                .isEqualTo(0);
    }

    @AfterEach
    public void after() {
        randoms.close();
    }
}
