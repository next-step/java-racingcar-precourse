package racinggame;

public class Application {
    public static void main(String[] args) {

        String[] carNames = inputCarNames();
        int racingTime = inputRacingTime();

    }

    private static int inputRacingTime() {
        String racingTime = InputView.readRacingTime();
        while (!ValidationUtils.isNum(racingTime)) {
            racingTime = InputView.readRacingTime();
        }
        return Integer.parseInt(racingTime);
    }

    private static String[] inputCarNames() {
        boolean incorrectCarName = true;
        String[] carNames = null;
        while (incorrectCarName) {
            carNames = SplitUtils.split(InputView.readCarNames());
            incorrectCarName = isIncorrectCarName(carNames);
        }
        return carNames;
    }

    private static boolean isIncorrectCarName(String[] carNames) {
        for(String carName : carNames) {
            if(!ValidationUtils.isCarNameLessThan5words(carName)) return true;
        }
        return false;
    }
}
