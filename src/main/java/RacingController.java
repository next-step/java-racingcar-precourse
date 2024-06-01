public class RacingController {
    private RacingView view = new RacingView();;
    private Racing model;

    public RacingController() {
        this.model = setRacing();
    }

    private String[] readCars() {
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

        return cars;
    }

    private int readTryCnt() {
        int tryCount;

        while (true) {
            try {
                String num = view.readTryCount();
                tryCount = RacingInputHandler.tryCntToInt(num);
                break;
            } catch (IllegalArgumentException e) {
                view.printError(e);
            }
        }

        return tryCount;
    }

    private Racing setRacing() {
        return new Racing(readCars(), readTryCnt());
    }

}
