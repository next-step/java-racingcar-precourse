public class RacingGame {
    public static void main(String[] args) {
        RacingGameView view=new RacingGameView();
        RacingGameController controller=new RacingGameController(view);
        controller.startGame();
    }

}
