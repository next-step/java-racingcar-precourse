package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Match {
    private final Drivers drivers;

    public Match(Drivers drivers) {
        this.drivers = drivers;
    }

    public Drivers getDrivers() {
        return drivers;
    }

    public void paly(){
        for(Driver driver : this.drivers.getDrivers()){
            driver.move(Randoms.pickNumberInRange(0,9));
        }
    }

    public String result(){
        final List<String> result = new ArrayList<>();
        String max = this.drivers.getDrivers().stream().max(Comparator.comparing(Driver::getDistance)).orElse(new Driver("dumy")).getDistance();

        for(Driver driver : drivers.getDrivers()){
            if(driver.getDistance().equals(max)){
                result.add(driver.getName());
            }
        }

        return String.join(",", result);
    }
}
