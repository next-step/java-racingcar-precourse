import java.util.ArrayList;
import java.util.List;

public class Utils {
	public static CarStatus getCarStatus(int number) {
		if (number > 3) {
			return CarStatus.MOVE;
		}

		return CarStatus.STOP;
	}

	public static boolean carStatusEqualsGoalCheck(Car car) {
		if (CarStatus.GOAL == car.getCarStatus()) {
			return true;
		}

		return false;
	}

	public static List<Car> getCarStatusEqualsGoal(List<Car> cars) {
		List<Car> carList = new ArrayList<>();
		for (Car car : cars) {
			if (carStatusEqualsGoalCheck(car)) {
				carList.add(car);
			}
		}

		return carList;
	}
}
