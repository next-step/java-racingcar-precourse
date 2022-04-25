package model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.prefs.BackingStoreException;

public class Car {
    private String carName;
    private BlackBox blackBox;

    public Car(String carName, BlackBox blackBox){
        this.carName = carName;
        this.blackBox = blackBox;
    }

    public String getCarName(){
        return carName;
    }

    public void go(){
        blackBox.writeRecord(true);
    }

    public void stop(){
        blackBox.writeRecord(false);
    }

    public int readBlackBox(int startTime, int endTime){
        return blackBox.readAccelCount(startTime, endTime);
    }

    public int readBlackBoxRecordSize(){
        return blackBox.readRecordSize();
    }

    public void tryAccel(int accelCount) {
        for(int i = 0; i < accelCount; i++) {
            tryAccel();
        }
    }

    private void tryAccel(){
        int stepPower = Randoms.pickNumberInRange(1,9);
        if(stepPower>=4){
            go();
        }
        stop();
    }
}
