package racinggame;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class Cars {
	public static final int MIN_PICK_NUMBER = 0;
	public static final int MAX_PICK_NUMBER = 9;
	public static final String ERROR_MESSAGE =
		"[ERROR] 공백을 입력하였거나 쉼표(,) 사이에 공백이 있는지 확인해주세요.";

	private List<Car> cars = new ArrayList<>();

	public Cars(String carNames) {
		try {
			validateCarNameIsEmpty(carNames);
			addCars(carNames);
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			throw new IllegalArgumentException(ex.getMessage());
		}
	}

	private void addCars(String carNames) {
		String[] splitCarName = carNames.split(",");
		for (int i = 0; i < splitCarName.length; i++) {
			validateCarNameIsEmpty(splitCarName[i]);
			cars.add(i, new Car(new CarName(splitCarName[i]),
				new CarMove(Randoms.pickNumberInRange(MIN_PICK_NUMBER, MAX_PICK_NUMBER))));
		}
	}

	private void validateCarNameIsEmpty(String carNames) {
		if ("".equals(carNames) || carNames == null) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
	}

	public int getSize() {
		return cars.size();
	}

	public String getCarName(int position) {
		return cars.get(position).getCarName();
	}
}
