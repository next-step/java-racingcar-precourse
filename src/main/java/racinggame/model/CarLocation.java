package racinggame.model;

import racinggame.environments.GlobalVariables;

public class CarLocation {
    private int location;

    public CarLocation(){
        this.location = GlobalVariables.START_CAR_LOCATION;
    }

    public CarLocation(int location){
        this.location = location;
    }

    public CarLocation(CarLocation other){
        this.location = other.get();
    }

    public void increase(){
        this.location++;
    }

    public int get(){
        return this.location;
    }

    public CarLocation getGreaterCompareWith(CarLocation other){
        return this.isGreaterThan(other) ? this : other;
    }

    public Boolean isGreaterThan(CarLocation other){
        return this.location > other.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarLocation)) return false;
        CarLocation that = (CarLocation) o;

        return location == that.location;
    }
}
