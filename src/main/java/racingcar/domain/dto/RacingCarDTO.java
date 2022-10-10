package racingcar.domain.dto;

import racingcar.domain.Location;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarName;

public class RacingCarDTO {
    private final RacingCarName racingCarName;
    private final Location location;

    public RacingCarDTO(RacingCar car) {
        RacingCar copy = RacingCar.copy(car);
        this.racingCarName = copy.getRacingCarName();
        this.location = copy.getLocation();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(racingCarName.getRacingCarNameValue());
        sb.append(" : ");
        for (int i = 0; i < location.getLocationValue(); i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
