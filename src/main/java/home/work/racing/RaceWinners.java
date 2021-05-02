package home.work.racing;

import home.work.racing.plural.PlayerCars;
import home.work.racing.wrap.CarMove;
import lombok.Getter;

@Getter
public class RaceWinners {

	private CarMove winnerMove;
	private PlayerCars cars = new PlayerCars();

	public RaceWinners(CarMove winnerMove) {
		if (winnerMove == null) {
			throw new IllegalArgumentException("승리를 판단할 거리가 없음");
		}
		this.winnerMove = winnerMove;
	}
	
	public void addCar(PlayerCar car) {
		if (car == null) {
			throw new IllegalArgumentException("승리를 파단할 차 없음");
		}
		if (this.winnerMove.equals(car.getMove())) {
			this.cars.addCar(car);
		}
	}

}