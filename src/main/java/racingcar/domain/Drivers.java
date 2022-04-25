package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Drivers {
    private final List<Driver> drivers = new ArrayList<>();

    public Drivers(String[] userInput){
        for(String driverName : userInput){
            drivers.add(new Driver(driverName));
        }
    }

    public List<Driver> getDrivers() {
        return drivers;
    }
}
