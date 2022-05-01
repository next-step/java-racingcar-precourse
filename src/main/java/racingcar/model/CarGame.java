package racingcar.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eunbi on 2022/04/23
 */
public class CarGame {
	private List<Car> carList = new ArrayList<>();
	private int tryNum = 0;

	public CarGame() {
		this.carList = new ArrayList<>();
		this.tryNum = 0;
	}

	public List<Car> getCarList() {
		return carList;
	}

	public void setCarList(List<Car> carList) {
		this.carList = carList;
	}

	public int getTryNum() {
		return tryNum;
	}

	public void setTryNum(int tryNum) {
		this.tryNum = tryNum;
	}
}
