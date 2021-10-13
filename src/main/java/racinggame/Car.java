package racinggame;

public class Car {
    public static final int MIN_NO = 1;
    public static final int MAX_NO = 9;
    public static final int GO_STOP_NUM = 4;

    private String carName = "";
    private String goSize = "";

    public Car(String carName){
        this.carName = carName;
    }

    public void goStopCheck(int goStopNum) {
        if( goStopNum >= GO_STOP_NUM){
            addGoSize();
        }
    }

    public void setCarName(String carName){
        this.carName = carName;
    }

    public String getCarName(){
        return this.carName;
    }

    public void setGoSize(String goSize){
        this.goSize = goSize;
    }

    public String getGoSize(){
        return this.goSize;
    }

    public void addGoSize(){
        String go_size = this.getGoSize();
        go_size += "-";
        setGoSize(go_size);
    }

    public String getCarNumGoSize(){
        return getCarName()+" : "+getGoSize();
    }

}
