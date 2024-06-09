import controller.RacingController;

public class Application {
    public static void main(String[] args) {
        RacingController rc = new RacingController();
        //input
        rc.inputCarNames();
        rc.inputNumOfTry();

        //racing
        rc.racingStart();
        rc.showWinner();
    }
}
