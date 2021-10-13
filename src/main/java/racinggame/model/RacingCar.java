package racinggame.model;

public class RacingCar{
    private String carName;
    private int currentMove;

    public RacingCar() {
    }

    public String getCarName(){
        return this.carName;
    }

    public void setCarName(String inputCarName){
        this.carName = inputCarName;
    }
}