package racinggame.view;

import racinggame.domain.CarStatus;
import racinggame.domain.Cars;
import racinggame.message.ErrorMessage;
import racinggame.message.PlayMessage;

public class RacinggameView {
	public void showRequestCarNameInputMessage() {
		System.out.println(PlayMessage.REQUEST_CAR_NAME_INPUT.getValue());
	}

	public void showRequestMoveCountInputMessage() {
		System.out.println(PlayMessage.REQUEST_MOVE_COUNT_INPUT.getValue());
	}

	public void showErrorMessage(String errorName) {
		System.out.println(ErrorMessage.ERROR_MESSAGE_PREFIX.getValue() + ErrorMessage.valueOf(errorName).getValue());
	}

	public void showPlayResultStartMessage() {
		System.out.println(PlayMessage.PLAY_RESULT_START.getValue());
	}

	public void showPlayResultMessage(Cars cars) {
		for (int i = 0; i < cars.getCarsCount(); i++) {
			CarStatus carStatus = cars.getCarStatusByIndex(i);
			System.out.println(carStatus.getCarName() + " : " + createVisualizedDistance(carStatus.getCarPosition()));
		}
	}

	private String createVisualizedDistance(int carPosition) {
		String visualizedDistance = "";
		for (int i = 0; i < carPosition; i++) {
			visualizedDistance += PlayMessage.DISTANCE_VISUALIZATION_UNIT.getValue();
		}
		return visualizedDistance;
	}

	public void showWinnerMessage(String winnerNames) {
		System.out.println(PlayMessage.WINNER_PREFIX.getValue() + winnerNames + PlayMessage.WINNER_SUFFIX.getValue());
	}
}
