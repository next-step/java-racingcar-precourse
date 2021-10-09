package racinggame;

import racinggame.view.InputView;
import racinggame.view.OutputView;


public class Application {
    public static void main(String[] args) {
    	Racing_game game=InputView.Input_CarName();
    	game.setTrycnt(Integer.parseInt(InputView.Input_game_chance()));
    	
    	//Output Logic ±¸Çö
    	OutputView.print_winner(game);
    }
}
