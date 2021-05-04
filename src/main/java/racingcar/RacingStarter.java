package racingcar;

public class RacingStarter {
    public static void main(String[] args) {
        RacingCars racingCars;
        RacingInputView racingInputView;
        RacingResultView RacingResultView;

        racingInputView = new RacingInputView();

        racingInputView.getRacingInfo();

        String[] cars = racingInputView.getCars();
        int count = racingInputView.getEventCount();

        racingCars = new RacingCars(cars);

        racingCars.startRacing(count);

    }
}
