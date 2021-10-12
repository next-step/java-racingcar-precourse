package racinggame.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("게임 결과 Domain Test")
class GameResultTest {

	@Test
	@DisplayName("게임 결과 가져오기, 승리 자동차 처리 Test")
	void getGameResultTest() {
		RacingCars racingCars = new RacingCars();
		Car jaguar = new Car("재규어");
		Car ferrari = new Car("페라리");
		racingCars.addCar(jaguar);
		racingCars.addCar(ferrari);
		GameResult gameResult = new GameResult(racingCars);
		assertEquals("재규어, 페라리 입니다.", gameResult.getGameResult());
	}
}