package model;

import Controller.InputController;
import Controller.OutputController;
import java.util.Set;

public class RaceManager {
    private InputController inControl;
    private OutputController outControl;

    private CarManager cm;

    private int raceNum;

    public RaceManager() {
        this.inControl = new InputController();
        this.outControl = new OutputController();
        cm = new CarManager();
        raceNum = 0;
    }

    public void raceSetup(){
        Set<String> cars = inControl.inputCarName();

        for(String s : cars){
            cm.addCar(s);
        }

        raceNum = inControl.inputRaceCount();

    }
}
