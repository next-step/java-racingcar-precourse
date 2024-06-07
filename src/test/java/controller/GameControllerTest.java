package controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameControllerTest {

    @Test
    @DisplayName("GameController 생성 테스트")
    public void testCreateGameController() {
        // given
        List<String> carNames = Arrays.asList("car1", "car2", "car3");
        int gameIteration = 5;

        // when
        GameController gameController = new GameController(carNames, gameIteration);

        // then
        assertThat(gameController.getGameIteration()).isEqualTo(gameIteration);
    }

    @Test
    @DisplayName("우승자 선정 시에 넣은 자동차 이름만 나오는지 테스트")
    public void testGetWinner() {
        // given
        List<String> carNames = Arrays.asList("car1", "car2", "car3");
        int gameIteration = 5;
        GameController gameController = new GameController(carNames, gameIteration);

        // when
        List<String> winner = gameController.getWinner();

        // then
        assertThat(winner).allMatch(carNames::contains);
    }
}