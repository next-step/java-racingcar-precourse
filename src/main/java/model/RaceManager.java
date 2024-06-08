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

    /**
     * 레이스를 위한 사용자 입력
     */
    public void raceSetup(){
        Set<String> cars = inControl.inputCarName();

        for(String s : cars){
            cm.addCar(s);
        }

        raceNum = inControl.inputRaceCount();

    }

    /**
     * 레이스 진행과 결과 출력
     */
    public void doRace(){
        for(int i=0;i<raceNum;i++){
            cm.race();
            outControl.printRaceLog(cm.getRaceLog());
        }

        outControl.printRaceWinner(cm.getFastCarName());
    }
}
