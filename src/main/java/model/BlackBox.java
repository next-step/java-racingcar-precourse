package model;

import java.util.ArrayList;
import java.util.List;

public class BlackBox {
    private List<Boolean> accelRecord = null;

    public BlackBox(){
        accelRecord = new ArrayList<Boolean>();
    }

    public int readAccelCount(int startTime, int endTime) {
        startTime = getUableTime(getTrueStartTime(startTime, endTime));
        endTime = getUableTime(getTrueEndTime(startTime, endTime));
        return getAccelCount(startTime, endTime);
    }

    private int getAccelCount(int startTime, int endTime){
        int accelCount = 0;
        for(int i = startTime; i < endTime; i++){
            if(accelRecord.get(i)){
                accelCount++;
            }
        }
        return accelCount;
    }

    private int getTrueStartTime(int startTime, int endTime){
        return startTime < endTime ? startTime : endTime;
    }

    private int getTrueEndTime(int startTime, int endTime){
        return startTime < endTime ? endTime : startTime;
    }

    private int getUableTime(int time) {
        if(time<=0){
            return 0;
        }
//        else if(time >= accelRecord.size()){
//        }
        return accelRecord.size();
//        throw new IllegalStateException("[ERROR]예상하지 못한 예외 발생");
    }

    public void writeRecord(boolean isGo){
        accelRecord.add(isGo);
    }

    public int readRecordSize(){
        return accelRecord.size();
    }
}
