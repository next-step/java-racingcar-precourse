public class RacingController {
    private RacingView view = new RacingView();;
    private Racing model;

    public RacingController() {
        this.model = setRacing();
    }

    private Racing setRacing() {
        String[] cars;
        while (true) {
            try {
                String carNames = view.readCarNames();
                cars = RacingInputHandler.splitCarNames(carNames);
                break;
            } catch (IllegalArgumentException e) {
                view.printError(e);
            }
        }

        int num;
        while (true) {
            try {
                String tryCount = view.readTryCount();
                num = RacingInputHandler.tryCntToInt(tryCount);
                break;
            } catch (IllegalArgumentException e) {
                view.printError(e);
            }
        }

        return new Racing(cars, num);
    }

}
