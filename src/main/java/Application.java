public class Application {
    public static void main(String[] args) {
        RacingView racingView = new RacingView();
        String carNames = racingView.readCarNames();
        String[] cars = RacingInputHandler.splitCarNames(carNames);
        System.out.println(cars);

        String tryCount = racingView.readTryCount();
        System.out.println(tryCount);
    }
}
