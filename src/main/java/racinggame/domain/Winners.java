package racinggame.domain;

import static racinggame.common.CommonConstants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * 우승자들을 저장하는 콜렉션
 *
 * @author Lee JungHo <jparangdev@gmail.com>
 * @version 1.0
 * @since 1.0
 */
public class Winners {
	List<Car> carList;

	public Winners() {
		this.carList = new ArrayList<>();
	}

	public List<Car> getCarList() {
		return carList;
	}

	/**
	 * 우승 자동차 추가
	 *
	 * @param car 우승 자동차
	 */
	public void addWinner(Car car) {
		if (car != null) {
			carList.add(car);
		}
	}

	@Override
	public String toString() {
		StringJoiner joiner = new StringJoiner(DELIMITER);
		for (Car car : carList) {
			joiner.add(car.getName());
		}
		return joiner.toString();
	}
}
