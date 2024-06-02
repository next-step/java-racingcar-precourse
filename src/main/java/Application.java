import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingCarGame Game = new RacingCarGame();
        boolean res = false;
        while(!res){
            res = Game.setCarNames();
        }
        res = false;
        while(!res){
            res = Game.setTryNum();
        }
        Game.racingStart();
        List<String> winner = Game.findWinner();
        Game.printWinner(winner);

    }
}
