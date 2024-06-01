public class Application {
    public static void main(String[] args) {
        RacingView racingView = new RacingView();
        String carNames = racingView.readCarNames();
        System.out.println(carNames);

    }
}
