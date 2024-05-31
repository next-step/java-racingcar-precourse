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

    public String InputCarsName() throws IOException {
        return InputView.inputName();
    }

    public void separateName(String name) {
        beforeCheckCarNames = name.split(",");
    }

    public boolean makeCars(String[] carNames) {
        cars = new Car[carNames.length];
        for (int i = 0; i < cars.length; i++) {
            if (!CheckNameValidity.checkNameValidity(carNames[i])) {
                return false;
            }
            cars[i] = new Car(carNames[i], "", 0);
        }
        return true;
    }
}
