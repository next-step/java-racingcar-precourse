package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultGameServiceTest {

    ResultGameService resultGameService;

    @BeforeEach
    void setUp() {
        String[] names = {"pobi", "dobi"};
        int[] gameCount = {1, 3};
        resultGameService = new ResultGameService(names, gameCount);
    }

    @Test
    void resultGame() {
        resultGameService.resultGame();
    }

    @Test
    void resultGameWin() {
        resultGameService.resultGameWin();
    }

    @Test
    void resultGameCoWin() {
        String[] names = {"pobi", "dobi"};
        int[] gameCount = {3, 3};
        resultGameService = new ResultGameService(names, gameCount);
        resultGameService.resultGameWin();
    }

}