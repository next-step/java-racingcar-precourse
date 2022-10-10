package racingcar.view;

import racingcar.common.ErrorMessage;

public class BasicBillBoard implements BillBoard {
    private final UserOutput userOutput;

    public BasicBillBoard(UserOutput userOutput) {
        this.userOutput = userOutput;
    }

    @Override
    public void showRequestCarName() {
        this.userOutput.show(BillBoardMessages.REQUEST_CAR_NAMES);
    }

    @Override
    public void showRequestRaceCount() {
        this.userOutput.show(BillBoardMessages.REQUEST_RACE_COUNT);
    }

    @Override
    public void showResultHeader() {
        this.userOutput.show("");
        this.userOutput.show(BillBoardMessages.RACE_RESULT_HEADER);
    }

    @Override
    public void showRace(RaceCarViews currentView) {
        for (RaceCarView carView : currentView) {
            this.userOutput.show(carView.toString());
        }
        this.userOutput.show("");
    }

    @Override
    public void showWinner(WinnerRacingCarViews winnerViews) {
        this.userOutput.show(String.format("%s%s", BillBoardMessages.RACE_WINNER_HEADER, winnerViews.getWinners()));
    }

    @Override
    public void showErrorMessage(ErrorMessage message) {
        this.userOutput.show(String.format("%s%s", BillBoardMessages.ERROR_HEADER, message));
    }
}
