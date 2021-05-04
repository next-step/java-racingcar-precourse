package domain.car.winner;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.car.Position;
import domain.car.name.CarName;
import domain.car.result.CarMoveResult;
import domain.car.result.CarMoveResults;

class WinnersTest {

	@Test
	@DisplayName("우승자는 가장 전진한 자동차이다")
	void winners(){
		CarMoveResults results = new CarMoveResults();
		results.addCarMoveResult(CarMoveResult.of(CarName.of("1번"), new Position(2)));
		results.addCarMoveResult(CarMoveResult.of(CarName.of("2번"), new Position(5)));
		results.addCarMoveResult(CarMoveResult.of(CarName.of("3번"), new Position(3)));
		results.addCarMoveResult(CarMoveResult.of(CarName.of("4번"), new Position(5)));

		Winners winners = Winners.of(results);

		assertThat(winners).isNotNull();
		assertThat(winners.getWinners())
			.containsExactly(
				Winner.of("2번"), Winner.of("4번")
			);

	}

}
