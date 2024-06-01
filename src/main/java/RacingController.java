public class RacingController {
    private RacingView view = new RacingView();;
    private Racing model;

    public RacingController() {
        this.model = new Racing(readCars(), readTryCnt());
    }

    public void startRace() {
        CarProgress[] carProgresses = model.getCarProgresses();

        while (model.nextMove()){
            view.addRaceResult(carProgresses);
        }

        view.printRaceResult();
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

}
