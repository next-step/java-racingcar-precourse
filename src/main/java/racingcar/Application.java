package racingcar;

public class Application {
    public static void main(String[] args) {
        // init
        RacingView init = RacingView.init();

        // processing
        RacingContest racingContest = new RacingContest(init.getLapCount());
        racingContest.start(init.getCars());

        // result
        racingContest.result();
    }
}
