package Model;

public class RacingGameCar {
    private String carName;
    private int forward;

    // constructor
    public RacingGameCar(String carName, int forward) {
        this.carName = carName;
        this.forward = forward;
    }

    //getter
    public String getCarName() {
        return carName;
    }

    //setter
    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void forwardingCar(){
        this.forward+=1;
    }

}
