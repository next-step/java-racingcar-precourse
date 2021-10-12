package racinggame;

public class Car {
    public static final int GO_STOP_NUM = 4;

    public boolean goStopCheck(int goStopNum) {
        if(goStopNum >= GO_STOP_NUM){
            return true;
        }
        return false;
    }
}
