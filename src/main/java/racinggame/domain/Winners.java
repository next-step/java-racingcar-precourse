package racinggame.domain;

import static racinggame.common.CommonConstants.*;

import java.util.ArrayList;
import java.util.List;

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

	public void addWinner(Car car) {
		if (car != null) {
			carList.add(car);
		}
	}

	@Override
	public String toString() {
		List<String> winnersStr = new ArrayList<>();
		for (Car car : carList) {
			winnersStr.add(car.getName());
		}
		return String.join(DELIMITER, winnersStr);
	}
}
