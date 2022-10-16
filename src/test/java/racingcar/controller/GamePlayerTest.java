package racingcar.controller;

import org.junit.jupiter.api.Test;
import racingcar.model.Cars;
import racingcar.model.Name;
import racingcar.model.Position;
import racingcar.view.GameResult;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GamePlayerTest {
    GamePlayer player = new GamePlayer(3);
    GameFactory factory = new GameFactory();
    Cars cars = factory.makeCars("a,b,c");
    @Test
    public void winnerPosition(){
        Cars movedCars = player.play(cars);
        Position winnerPosition = player.getMaxPosition();
        int max = 0 ;
        for (int i = 0; i < movedCars.size(); i++) {
            max = Math.max(movedCars.getCar(i).getPosition().getPosition(),max);
        }
        assertThat(winnerPosition).isEqualTo(new Position(max));
    }

    @Test
    public void winnerNames(){
        Cars movedCars = player.play(cars);
        Position winnerPosition = player.getMaxPosition();
        List<Name> list = new ArrayList<>();
        for (int i = 0; i < movedCars.size(); i++) {
            if(winnerPosition.equals(cars.getCar(i).getPosition())){
                list.add(cars.getCar(i).getName());
            }
        }
        GameResult result = new GameResult(list);
        GameResult winnerNames = player.findWinnerNames(cars);

        assertThat(result.getGameResult()).isEqualTo(winnerNames.getGameResult());
    }
}
