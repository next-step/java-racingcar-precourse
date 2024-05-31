package Controller;

import Model.Car;
import Model.Player;
import Model.Winner;
import Model.WinnerNumber;
import Util.CheckNameValidity;
import Util.CheckNumberValidity;
import Util.MakeRandomNumber;
import Util.MoveOrNot;
import VIew.InputView;
import VIew.OutputView;
import java.io.IOException;
import java.util.StringTokenizer;

public class Game {

    private Car[] cars;
    private String[] beforeCheckCarNames;
    private StringTokenizer carNames;
    private Player player;
    private Winner winner;
    private int winnerNumber;

    public void separateName(String name) {
        beforeCheckCarNames = name.split(",");
    }

    public boolean makeCars() {
        cars = new Car[beforeCheckCarNames.length];
        for (int i = 0; i < cars.length; i++) {
            if (!CheckNameValidity.checkNameValidity(beforeCheckCarNames[i])) {
                return false;
            }
            cars[i] = new Car(beforeCheckCarNames[i], "", 0);
        }
        return true;
    }

    public void makeCorrectCars()throws IOException{
        do {
            OutputView.outputInputCarNameMessage();
            String names = InputView.inputName();
            separateName(names);
        }while (makeCars());
    }

    public void makeCorrectPlayer()throws IOException{
        OutputView.outputLine("시도할 회수는 몇회인가요?");
        String numberOfAttempts = InputView.inputNumberOfAttempts();
        while(!CheckNumberValidity.checkNumberValidity(numberOfAttempts)){
            OutputView.outputLine("다시~~~");
        }
        player = new Player(Integer.parseInt(numberOfAttempts));
    }

    public void allCarMoveOrNot(){
        for(int i = 0; i < cars.length; i++){
            int randomNumber = MakeRandomNumber.makeRandomNumber();
            MoveOrNot.checkMoveOrNot(randomNumber,cars[i]);
        }
    }

}
