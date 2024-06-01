public class Application {
    public static void main(String[] args) {

        RacingView racingView = new RacingView();

        String[] cars;

        while (true) {
            try {
                String carNames = racingView.readCarNames();
                cars = RacingInputHandler.splitCarNames(carNames);
                break;
            } catch (IllegalArgumentException e) {
                racingView.printError(e);
            }
        }
        System.out.println(cars);

        int num;
        while (true) {
            try {
                String tryCount = racingView.readTryCount();
                num = RacingInputHandler.tryCntToInt(tryCount);
                break;
            } catch (IllegalArgumentException e) {
                racingView.printError(e);
            }
        }
        System.out.println(num);
    }
}
