package domain;

import domain.history.CarHistories;
import domain.name.CarNames;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    @Test
    @DisplayName("움직임을 할 때 마다 현재 위치 계속 갖고 있는다.")
    public void 움직임을_할_때_마다_현재_위치_계속_갖고_있는다() {
        int times = 5;
        CarNames carNames = new CarNames("a,b,c");
        Game game = new Game(carNames, () -> true);

        game.move(new TryCount(times));

        List<CarHistories> moveHistories = game.getMoveHistories();

        for(int i = 1; i<=times; i++) {
            CarHistories histories = moveHistories.get(i - 1);
            for(Position position : histories.getPositions()) {
                assertThat(position.toInt())
                        .isEqualTo(i);
            }
        }
    }
}
