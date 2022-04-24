package racingcar.vo;

import java.util.ArrayList;
import java.util.List;
import racingcar.constant.MoveStatus;

public class RacingCar {

    private final String carName;
    private final List<Integer> locationHistory;
    private int location;

    public RacingCar(String carName) {
        this.carName = carName;
        this.location = 0;
        this.locationHistory = new ArrayList<>();
    }

    public String getCarName() {
        return carName;
    }

    public void updateLocation(MoveStatus moveStatus) {
        if (MoveStatus.FORWARD.equals(moveStatus)) {
            location++;
        }
        locationHistory.add(location);
    }

    public int getLocation() {
        return location;
    }

    public List<Integer> getLocationHistory() {
        return locationHistory;
    }
}
