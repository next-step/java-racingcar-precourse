package racinggame.model;

import java.util.Objects;

public class CarLocation {
    int location;

    public CarLocation(int location){
        this.location = location;
    }

    public void increase(){
        this.location++;
    }

    public int get(){
        return this.location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarLocation)) return false;
        CarLocation that = (CarLocation) o;

        return location == that.location;
    }
}
