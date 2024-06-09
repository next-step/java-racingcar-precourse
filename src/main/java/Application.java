import Controller.RacingController;

public class Application {
    public static void main(String[] args) {
        RacingController rc = RacingController.getInstance();
        rc.run();
    }
}