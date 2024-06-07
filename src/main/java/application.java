import config.RacingCarConfig;
import controller.RacingCarFrontController;

public class application {

    public static void main(String[] args) {

        RacingCarFrontController racingCarFrontController = new RacingCarFrontController(
            RacingCarConfig.getRacingCarController());

        racingCarFrontController.run();
    }
}
