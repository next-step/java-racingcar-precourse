package raceCar;

import java.util.LinkedHashMap;

import raceCar.model.Car;
import raceCar.model.RaceCourse;

public class GameManager {
	private RaceCourse raceCourse;
	// 게임 초기화
	public void initGame() {
		raceCourse = RaceCourse.of(new LinkedHashMap<>());
	}

	// RaceCource 에 차량 등록
	public void addCar(String[] carNames) {
		for (String carName : carNames) {
			raceCourse.addCar(Car.of(carName));
		}
	}

	// 라운드 진행
	public void runRound() {
		raceCourse.getTrack().forEach((car, distance) -> {
			if (car.canMove()) {
				raceCourse.getTrack().put(car, distance + 1);
			}
		});
	}

	// 결과 발표
	public String announceResult() {
		StringBuilder result = new StringBuilder();
		raceCourse.getTrack().forEach((car, distance) -> {
			result.append(car.getName()).append(" : ");
			for (int i = 0; i < distance; i++) {
				result.append("-");
			}
			result.append("\n");
		});
		return result.toString();
	}

	// 우승자 발표
	public String announceWinner() {
		// 정렬 후 거리가 달라질때 까지 우승자 추가
		StringBuilder winner = new StringBuilder();
		int maxDistance = raceCourse.getTrack().values().stream().max(Integer::compareTo).orElse(0);
		for (Car car : raceCourse.getTrack().keySet()) {
			if (raceCourse.getTrack().get(car) == maxDistance) {
				winner.append(car.getName()).append(", ");
			}
		}
		return winner.substring(0, winner.length() - 2);
	}
}
