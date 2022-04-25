package racingcar.model;

import org.junit.jupiter.api.Test;

class ScoreBoardTest {

    @Test
    void testForScoreBoard() {
        String names = "java, jigi, value" ;
        Players players = new Players(names);
        for(int i = 0; i < 3; i++) {
            players.moveWithStrategy(() -> true);
        }

        String s = ScoreBoard.scoreBoardWithTemplate(players.currentScores());
        System.out.println(s);
    }
}