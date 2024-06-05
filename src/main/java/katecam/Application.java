package katecam;

import katecam.racingcar.adaptor.in.RacingCarController;
import katecam.config.AppConfig;

public class Application {
    private static final RacingCarController racingCarController = AppConfig.getRacingCarController();
    private static final RacingCarView racingCarView = new RacingCarView();

    public static void main(String[] args) {
        boolean valid = false;
        while (!valid)
            try{
                racingCarController.initGame(racingCarView.getCarNames(), racingCarView.getNumberToAttempt());
                racingCarView.display("\n실행 결과");
                valid = true;
            }catch (IllegalArgumentException e){
                racingCarView.display(e.getMessage());
            }
        do{
            racingCarController.playTurn();
            racingCarView.display(racingCarController.getTurnResult());
        }while(!racingCarController.isEnded());
        racingCarView.display(racingCarController.getTotalResult());
    }
}
