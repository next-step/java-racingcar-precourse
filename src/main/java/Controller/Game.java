package Controller;

import Model.Car;
import Model.Player;
import Model.Winner;
import Model.WinnerNumber;
import Util.CheckNameValidity;
import VIew.InputView;
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
            String names = InputView.inputName();
            separateName(names);
        }while (makeCars());
    }

}
