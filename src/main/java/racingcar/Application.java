package racingcar;

import racingcar.model.*;
import racingcar.ui.Output;

public class Application {
    public static void main(String[] args) {
        Prepare prepare = new Prepare();
        Racing racing = new Racing();
        Cars cars = new Cars();

        cars.setCars(prepare.requestCarName().getCars());
        int racingAttempt;
        do{
            racingAttempt = prepare.requestAttempt();
        }while(racingAttempt == 0);

        Output.printResultMessage();
        while(racingAttempt-- > 0){
            cars.setCars(racing.start(cars).getCars());
            Output.printEmptyLine();
        }
        Referee referee = new Referee();
        Output.printResultWinnerMessage(referee.getWinner(cars));
    }
}