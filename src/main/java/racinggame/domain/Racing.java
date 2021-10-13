package racinggame.domain;

import static racinggame.common.ErrorMessage.*;

import java.util.List;

/**
 * 레이싱을 진행하고 우승자를 판단하는 역할을 하는 클래스
 *
 * @author Lee JungHo <jparangdev@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Racing {

	Cars cars;
	RacingResults racingResults;
	Winners winners;
	int tryCount;

	public Racing() {
		cars = new Cars();
		winners = new Winners();
		racingResults = new RacingResults();
	}

	public Cars getCars() {
		return cars;
	}

	public void setTryCount(int tryCount) {
		this.tryCount = tryCount;
	}

	public Winners getWinner() {
		return winners;
	}

	public RacingResults getRacingResults() {
		return racingResults;
	}

	public void join(Car car) {
		cars.addCar(car);
	}

	/**
	 * 자동차 이름 목록을 통한 자동차 참가
	 *
	 * @param nameList 추가되는 자동차 이름 목록
	 */
	public void joinList(List<String> nameList) {
		for (String name : nameList) {
			join(new Car(name));
		}
	}

	/**
	 * 레이스를 진행 후 결과를 저장
	 */
	public void run() {
		cars.racing();
		racingResults.addResult(cars.currentStatusString());
	}

	/**
	 * 우승자를 판단
	 */
	public void audit() {
		int maxDistance = cars.maxDistance();
		for (Car car : cars.getCarList()) {
			addWinnerList(maxDistance, car);
		}
	}

	/**
	 * 최대 거리에 도달한 자동차를 우승자 목록에 저장
	 *
	 * @param max 최대 이동거리
	 * @param car 추가되는 자동차
	 */
	public void addWinnerList(int max, Car car) {
		if (car.getDistance() == max) {
			winners.addWinner(car);
		}
	}

	/**
	 * 시도 회수 만큼 레이싱 진행 후 우승자 판단
	 */
	public void startRacing() {
		if (cars.size() == 0) {
			throw new IllegalStateException(ERROR_NO_CARS);
		}
		for (int i = 0; i < tryCount; i++) {
			run();
		}
		audit();
	}

}
