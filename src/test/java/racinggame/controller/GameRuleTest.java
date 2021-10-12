package racinggame.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racinggame.domain.Car;
import racinggame.domain.GameResult;
import racinggame.domain.MoveCount;
import racinggame.domain.RacingCars;

@DisplayName("게임 룰 컨트롤러 Test")
class GameRuleTest {

	@Test
	@DisplayName("게임 시작 Test")
	void gameStartTest() {
		RacingCars racingCars = new RacingCars();
		MoveCount moveCount = new MoveCount(3);
		Car lam = new Car("람보르기니");
		Car truck = new Car("트럭");
		racingCars.addCar(lam);
		racingCars.addCar(truck);
		GameRule gameRule = new GameRule(racingCars, moveCount);
		gameRule.gameStart();
	}

	@Test
	@DisplayName("게임 결과 반환 Test")
	void getGameResultTest() {
		RacingCars racingCars = new RacingCars();
		MoveCount moveCount = new MoveCount(3);
		Car lam = new Car("람보르기니");
		Car truck = new Car("트럭");
		racingCars.addCar(lam);
		racingCars.addCar(truck);
		GameRule gameRule = new GameRule(racingCars, moveCount);
		assertEquals("람보르기니, 트럭 입니다.", gameRule.getGameResult());

	}
}