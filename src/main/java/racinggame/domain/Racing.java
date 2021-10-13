package racinggame.domain;

import static racinggame.common.ErrorMessage.*;

/**
 * 레이싱을 진행하고 우승자를 판단하는 역할을 하는 클래스
 *
 * @author Lee JungHo <jparangdev@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Racing {

	Cars cars;
	TryCount tryCount;

	public Racing() {
		cars = new Cars();
		tryCount = new TryCount();
	}

	public Cars getCars() {
		return cars;
	}

	public void setTryCount(TryCount tryCount) {
		this.tryCount = tryCount;
	}

	public void join(Car car) {
		cars.addCar(car);
	}

	/**
	 * 자동차 이름 목록을 통한 자동차 참가
	 *
	 * @param carNames 추가되는 자동차 이름들 객체
	 */
	public void joinList(CarNames carNames) {
		for (String name : carNames.getCarNameList()) {
			join(new Car(name));
		}
	}

	/**
	 * 레이스를 진행 후 결과를 저장
	 */
	public String run() {
		cars.racing();
		return cars.currentStatusString();
	}

	/**
	 * 우승자를 판단
	 */
	public Winners getWinners() {
		Winners winners = new Winners();
		int maxDistance = cars.maxDistance();
		for (Car car : cars.getCarList()) {
			winners.addWinner(audit(maxDistance, car));
		}
		return winners;
	}

	/**
	 * 최대 거리에 도달한 자동차를 반환
	 *
	 * @param max 최대 이동거리
	 * @param car 추가되는 자동차
	 */
	public Car audit(int max, Car car) {
		if (car.getDistance() == max) {
			return car;
		}
		return null;
	}

	/**
	 * 시도 회수 만큼 레이싱 진행 후 우승자 판단
	 */
	public RacingResults startRacing() {
		if (cars.size() == 0) {
			throw new IllegalStateException(ERROR_NO_CARS);
		}
		RacingResults results = new RacingResults();
		for (int i = 0; i < tryCount.getTryCount(); i++) {
			results.addResult(run());
		}
		return results;
	}

}
