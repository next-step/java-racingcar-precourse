public class GameController {
    private Car[] carList;
    private int playCount;
    private GameInputView gameInputView;

    public GameController() {
        gameInputView = new GameInputView();
    }

    public void gameSetting() {
        String[] carNames = gameInputView.inputCarNames();
        int carNamesLength = carNames.length;
        int playCount = gameInputView.inputPlayCount();

        carList = new Car[carNamesLength];
        for (int i=0; i<carNamesLength; i++) {
            carList[i] = new Car(carNames[i]);
        }

        this.playCount = playCount;
    }
}
