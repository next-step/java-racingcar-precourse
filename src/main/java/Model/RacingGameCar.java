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

    //getter
    public int getForward() {
        return forward;
    }

    //setter
    public void setForward(int forward) {
        this.forward = forward;
    }

    public void forwardingCar(){
        this.forward+=1;
    }

    @Override
    public String toString() {
        return this.carName+" : "+ "-".repeat(this.forward);
    }
}
