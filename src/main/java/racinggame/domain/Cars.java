package racinggame.domain;

import static racinggame.common.CommonConstants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import nextstep.utils.Randoms;

/**
 * 자동차들의 일급콜렉션
 *
 * @author Lee JungHo <jparangdev@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Cars {

	List<Car> carList;

	public Cars() {
		this.carList = new ArrayList<>();
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void addCar(Car car) {
		if (car != null) {
			carList.add(car);
		}
	}

	public int size() {
		return carList.size();
	}

	/**
	 * 자동차들의 레이스를 진행
	 */
	public void racing() {
		for (Car car : carList) {
			car.race(Randoms.pickNumberInRange(RANDOM_MIN_LENGTH, RANDOM_MAX_LENGTH));
		}
	}

	/**
	 * 자동차들중 최대 이동 거리를 반환
	 *
	 * @return 최대 이동 거리
	 */
	public int maxDistance() {
		int maxDistance = 0;
		for (Car car : carList) {
			int distance = car.getDistance();
			maxDistance = Math.max(distance, maxDistance);
		}
		return maxDistance;
	}

	/**
	 * 자동차들의 현재 상태를 문자열로 반환
	 *
	 * @return 현제 레이스 진행 상황
	 */
	public String currentStatusString() {
		StringJoiner joiner = new StringJoiner(NEW_LINE);
		for (Car car : carList) {
			joiner.add(car.toString());
		}
		return joiner.toString();
	}
}
