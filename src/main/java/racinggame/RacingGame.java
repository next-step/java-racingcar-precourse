package racinggame;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Console;
import nextstep.utils.Valid;

public class RacingGame {
	public List<Car> carSetup() {
		String cars = "";
		boolean isCarValid = false;
		while (isCarValid == false) {
			System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
			cars = Console.readLine();
			Valid valid = carValid(cars);
			isCarValid = valid.getValid();
			if (isCarValid == false) {
				System.out.println(valid.getMessage());
			}
		}
		List<Car> carList = new ArrayList<>();
		String[] carArray = cars.split(",");
		for (String carName : carArray) {
			Car car = new Car();
			car.setCarName(carName);
			carList.add(car);
		}
		return carList;
	}
	private Valid carValid(String cars) {
		Valid valid = new Valid();
		valid.setValid(false);
		if (cars == null || cars.length() < 1) {
			valid.setMessage("[ERROR] 올바른 자동차를 입력해주세요.");
			return valid;
		}
		String[] carArray = cars.split(",");
		if (cars == null || carArray.length < 2) {
			valid.setMessage("[ERROR] 자동차를 2대이상 입력하세요.");
			return valid;
		}
		for (String car : carArray) {
			if (car.length() > 5) {
				valid.setMessage("[ERROR] 자동차이름은 5글자 이하입니다.");
				return valid;
			}
		}
		valid.setValid(true);
		return valid;
	}
	public Integer tryCountSetup() {
		String tryCount = "";
		boolean isTryCountValid = false;
		while (isTryCountValid == false) {
			System.out.println("시도할 회수는 몇회인가요?");
			tryCount = Console.readLine();
			Valid valid = tryCountValid(tryCount);
			isTryCountValid = valid.getValid();
			if (isTryCountValid == false) {
				System.out.println(valid.getMessage());
			}
		}
		return Integer.valueOf(tryCount);
	}
	private Valid tryCountValid(String tryCount) {
		Valid valid = new Valid();
		if (tryCount == null || tryCount.length() < 1 || tryCount.matches("-?\\d+") == false) {
			valid.setValid(false);
			valid.setMessage("[ERROR] 올바른 숫자를 다시 입력해주세요.");
			return valid;
		}
		valid.setValid(true);
		return valid;
	}
}
