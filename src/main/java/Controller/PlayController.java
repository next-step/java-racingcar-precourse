package Controller;

public class PlayController {

    public static void play() {
        CarNameController name = new CarNameController();
        TryController count = new TryController();
        RacingController racing = new RacingController();
        WinnerController winners = new WinnerController();

        winners.getResult(racing.playRacing(name.getCarNames(), count.getTryCount()));

    }
}