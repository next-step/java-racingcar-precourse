package racingcar;

import racingcar.view.Message;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    public static final int CURRENT_ROUNDS_PLUS = 1;

    private Cars cars;
    private GameInfo gameInfo;
    private Message message;

    public void play() {
        int currentRounds = 0;
        message = new Message();

        requestCarsName();
        requestGameRounds();

        message.playResult();
        while(gameInfo.isPlay(currentRounds).equals(GameStatus.PLAY)) {
            cars.checkGear();

            message.roundsMessgae(cars);

            currentRounds = nextRounds(currentRounds);
        }

        message.finalWinner(getFinalWinnerList());
    }

    private int nextRounds(int currentRounds) {
        return currentRounds + CURRENT_ROUNDS_PLUS;
    }

    private String getFinalWinnerList() {
        String finalWinnerList = "";

        finalWinnerList = cars.getFinalWinnerList();

        return finalWinnerList;
    }

    private void requestCarsName() {
        message = new Message();

        while(true) {
            try {
                message.requestCarsName();
                this.cars = new Cars(readLine());
                return;
            } catch (IllegalArgumentException | IllegalStateException e) {
                message.error(e.getMessage());
            }
        }
    }

    private void requestGameRounds() {
        message = new Message();

        while(true) {
            try {
                message.requestGameRounds();
                this.gameInfo = new GameInfo(readLine());
                return;
            } catch (IllegalArgumentException | IllegalStateException e) {
                message.error(e.getMessage());
            }
        }
    }
}
