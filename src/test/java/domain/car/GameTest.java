package domain.car;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.car.name.CarNames;
import domain.car.result.CarMoveResult;
import domain.car.result.CarMoveResults;
import domain.car.strategy.ConditionMovableStrategy;

class GameTest {

	@Test
	@DisplayName("모든 움직임 기록을 가지고 있음")
	void game(){
		int times = 3;
		CarNames carNames = new CarNames("test1,test2,test3");
		Game game = new Game(carNames, new ConditionMovableStrategy(true));

		game.start(new MoveCount(times));

		List<CarMoveResults> allResult = game.getAllResult();
		for (int i = 0; i < times; i++) {
			CarMoveResults results = allResult.get(i);

			for (CarMoveResult carMoveResult : results.getCarMoveResults()) {
				assertThat(carMoveResult.getPosition()).isEqualTo(new Position(i));
			}
		}

	}

}