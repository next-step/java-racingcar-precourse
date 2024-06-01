import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

public class RacingGameTest {
    private MockRacingGameView view;
    private RacingGameController controller;

    @BeforeEach
    public void setUp(){
        view=new MockRacingGameView();
        controller=new RacingGameController(view);
    }

    @Test
    @DisplayName("RacingGame이 올바르게 시작하는지 테스트")
    public void testStartGame(){
        view.setCarNames(Arrays.asList("Na", "Gyu", "Kia"));
        view.setMoveCount(5);

        controller.startGame();

        assertThat(view.getPrintedCars()).isNotEmpty();
        assertThat(view.getWinner()).isNotEmpty();
    }

    @Test
    @DisplayName("View가 올바른 자동차 이름을 return하는지 테스트")
    public void testGetCarNames(){
        view.setCarNames(Arrays.asList("Na", "Gyu", "Kia"));
        List<String> carNames=view.getCarNames();
        assertThat(carNames).containsExactly("Na", "Gyu", "Kia");
    }

    @Test
    @DisplayName("View가 올바른 움직임 횟수를 return하는지 테스트")
    public void testGetMoveCount(){
        view.setMoveCount(5);
        int moveCount=view.getMoveCount();
        assertThat(moveCount).isEqualTo(5);
    }
}
