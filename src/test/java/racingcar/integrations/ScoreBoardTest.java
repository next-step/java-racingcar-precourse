package racingcar.integrations;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.mvc.domain.ScoreBoard;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreBoardTest {

    @Test
    @DisplayName("A가 1점, B가 0점인 경우")
    public void test_1() {
        String[] names = new String[]{"A", "B"};
        ScoreBoard scoreBoard = ScoreBoard.from(names);

        scoreBoard.scoreOne("A");

        assertThat(scoreBoard.whoAreTopScorer()).containsExactly("A");
    }

    @Test
    @DisplayName("A가 1점, B가 2점인 경우")
    public void test_2() {
        String[] names = new String[]{"A", "B"};
        ScoreBoard scoreBoard = ScoreBoard.from(names);

        scoreBoard.scoreOne("A");
        scoreBoard.scoreOne("B");
        scoreBoard.scoreOne("B");

        assertThat(scoreBoard.whoAreTopScorer()).containsExactly("B");
    }

    @Test
    @DisplayName("A가 3점, B가 2점, C가 1점인 경우")
    public void test_3() {
        String[] names = new String[]{"A", "B", "C"};
        ScoreBoard scoreBoard = ScoreBoard.from(names);

        scoreBoard.scoreOne("A");
        scoreBoard.scoreOne("A");
        scoreBoard.scoreOne("A");
        scoreBoard.scoreOne("B");
        scoreBoard.scoreOne("B");
        scoreBoard.scoreOne("C");

        assertThat(scoreBoard.whoAreTopScorer()).containsExactly("A");
    }

    @Test
    @DisplayName("A가 1점, B가 1점일 때는 공동 우승자 A,B를 반환한다.")
    public void test_4() {
        String[] names = new String[]{"A", "B", "C"};
        ScoreBoard scoreBoard = ScoreBoard.from(names);

        scoreBoard.scoreOne("A");
        scoreBoard.scoreOne("B");

        assertThat(scoreBoard.whoAreTopScorer()).containsExactly("A", "B");
    }

    @Test
    @DisplayName("A가 1점, B가 1점일, C가 1점일때는 때는 공동 우승자 A,B,C를 반환한다.")
    public void test_5() {
        String[] names = new String[]{"A", "B", "C"};
        ScoreBoard scoreBoard = ScoreBoard.from(names);

        scoreBoard.scoreOne("A");
        scoreBoard.scoreOne("B");
        scoreBoard.scoreOne("C");

        assertThat(scoreBoard.whoAreTopScorer()).containsExactly("A", "B", "C");
    }

}
