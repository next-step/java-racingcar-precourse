package racingcar.domain;

import static racingcar.utils.StringUtils.convertListToString;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private static final String DELIMETER = ",";
    private final List<RacingCar> racingCars;

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> playRacing() {
        for(RacingCar racingCar: racingCars) {
            racingCar.racing(new RandomNumber().convertRandomNumber());
        }
        return racingCars;
    }

    private int getMaxRacingCarLocation() {
        int maxLocation = 0;
        for(RacingCar racingCar: racingCars) {
            maxLocation = Math.max(maxLocation, racingCar.getCurrentLocation());
        }
        return maxLocation;
    }

    public String findWinners() {
        int maxRacingCarLocation = getMaxRacingCarLocation();
        List<String> winnerNames = new ArrayList<>();
        for(RacingCar racingCar: racingCars) {
            getCarNameIfIsWinner(racingCar, maxRacingCarLocation, winnerNames);
        }
        return convertListToString(winnerNames, DELIMETER);
    }

    private void getCarNameIfIsWinner(RacingCar racingCar, int maxRacingCarLocation, List<String> winnerNames) {
        if(racingCar.getCurrentLocation() == maxRacingCarLocation) {
            winnerNames.add(racingCar.getRacingCarName());
        }
    }
}
