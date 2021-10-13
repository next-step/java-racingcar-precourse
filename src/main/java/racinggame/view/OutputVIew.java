package racinggame.view;

import racinggame.model.Car;
import racinggame.model.Cars;

public class OutputVIew {

	private static final String POSITION_DASH = "-";
	private static final String ERROR_SUBSCRIPT = "[ERROR]";
	private static final CharSequence WINNERS_DELIMITER = ",";

	public void outputInGame(Car car) {
		String carName = car.getName();
		int carPosition = car.getDistance();
		StringBuilder stringBuilder = new StringBuilder(carName + " : ");
		while (carPosition-- > 0) {
			stringBuilder.append(POSITION_DASH);
		}

		outputUserView(stringBuilder.toString());
	}

	public void outputErrorMessage(String message) {
		System.out.println(ERROR_SUBSCRIPT + message);
	}

	public void outputWinners(Cars cars) {
		String winners = String.join(WINNERS_DELIMITER, cars.getWinners());
		outputUserView("최종 우승자는 " + winners + " 입니다.");
	}

	public void outputNewLine() {
		outputUserView("");
	}

	public void outputUserView(String message) {
		System.out.println(message);
	}

}
