package Controller;

import Model.Car;
import Model.Player;
import VIew.InputView;
import java.io.IOException;
import java.util.StringTokenizer;

public class Game {

    private Car[] cars;
    private StringTokenizer carNames;

    public String InputCarsName() throws IOException {
        return InputView.inputName();
    }

    public StringTokenizer separateName(String name) {
        return new StringTokenizer(name, ",");
    }

    


}
