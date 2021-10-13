package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.game.Game;
import racinggame.domain.users.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    private Game game;

    @Test
    @BeforeEach
    @DisplayName("게임 초기화 세팅")
    void 초기화() {
        User user = new User();
        this.game = new Game(user);
        int round = 5;//game.userInputRound();
        String[] carNames = {"차", "자동차", "슈퍼자동차"};//game.userInputCarNames();
        game.init(round, carNames);

        assertEquals(game.getCars().size(), carNames.length);
        assertEquals(game.getCars().get(0).getName(), carNames[0]);
    }
}
