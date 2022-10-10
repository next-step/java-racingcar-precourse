package racingcar.view;

import racingcar.common.ErrorMessage;

/**
 * @author garden.iee
 */
public interface BillBoard {
	void showRequestCarName();

	void showRequestRaceCount();

	void showResultHeader();

	void showRace(RaceCarViews currentView);

	void showWinner(WinnerRacingCarViews winnerViews);

	void showErrorMessage(ErrorMessage message);
}