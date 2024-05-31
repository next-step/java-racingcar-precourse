import java.util.List;

public class RacingGameController {
    private final RacingGameView view;
    private Race race;

    public RacingGameController(RacingGameView view){
        this.view=view;
    }

    public void startGame(){
        List<String> carNames = view.getCarNames();
        int moveCount = view.getMoveCount();

        Race race = new Race(carNames);
        for (int i = 0; i < moveCount; i++) {
            race.moveCars();
            view.printProgress(race.getCars());
        }

        List<Car> winner = race.getWinner();
        view.printWinner(winner);
    }

}
