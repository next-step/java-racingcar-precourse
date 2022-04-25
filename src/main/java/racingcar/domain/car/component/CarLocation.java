package racingcar.domain.car.component;

public class CarLocation {
    private String location;

    public CarLocation(){
        location = "";
    }

    public int getLocation(){
        return location.length();
    }

    public void moveForward(){
        location += "-";
    }

    @Override
    public String toString(){
        return location;
    }
}
