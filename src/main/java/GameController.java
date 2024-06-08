public class GameController {

    private Car[] carList;
    private int playCount;
    private GameInputView gameInputView;
    private GameOutputView gameOutputView;

    public GameController() {
        gameInputView = new GameInputView();
        gameOutputView = new GameOutputView();
    }

    public void gameSetting() {
        String[] carNames = gameInputView.inputCarNames();
        int carNamesLength = carNames.length;
        int playCount = gameInputView.inputPlayCount();

        carList = new Car[carNamesLength];
        for (int i = 0; i < carNamesLength; i++) {
            carList[i] = new Car(carNames[i]);
        }

        this.playCount = playCount;
    }

    public void gamePlay() {
        System.out.println("실행 결과");
        for (int i = 0; i < playCount; i++) {
            for (Car car : carList) {
                car.move();
            }

            gameOutputView.printPlayResult(carList);
        }
    }

    public void gameDone() {
        int winnerMoveCount = 0;

        for (Car car : carList) {
            int carMoveCount = car.getMoveCount();

            if (carMoveCount > winnerMoveCount) {
                winnerMoveCount = carMoveCount;
            }
        }

        gameOutputView.printWinner(carList, winnerMoveCount);
    }
}
