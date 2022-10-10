package racingcar;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        String[] carNames = inputView.inputCarNames();
        int tryCnt = inputView.inputTryCnt();
        RacingCars racingCars = new RacingCars(carNames);
        int maxPosition = 0;
        while(tryCnt-- > 0){
            maxPosition = racingCars.race();
            resultView.printCarPosition(racingCars.getRacingCarList());
        }
        resultView.printWinner(racingCars.getWinnerCar(maxPosition));
    }
}
