import domain.Car;
import domain.Cars;
import domain.RacingGame;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        InputView inputView = new InputView();
        String[] carNames = inputView.inputCarParticipateInRacingGame();

        int racingCount = inputView.inputRacingCount();

        List<Car> carList = new ArrayList<>();
        for(String carName : carNames){
            carList.add(new Car(carName));
        }

        Cars cars = new Cars(carList);

        RacingGame racingGame  = new RacingGame(racingCount,cars);

        Cars winners = racingGame.startRacing();
        OutputView outputView = new OutputView();
        outputView.printWinnerCars(winners);
    }
}
