package racingcar;

import racingcar.domain.Drivers;
import racingcar.domain.Match;
import racingcar.util.Input;
import racingcar.util.Output;

public class GameManager {
    public void run(){
        Drivers drivers = new Drivers(Input.userName());
        int round = Input.round();

        Match match = new Match(drivers);
        for(int a=0; round>a; a++){
            match.paly();
            Output.roundResult(match);
        }

        Output.result(match);
   }
}
