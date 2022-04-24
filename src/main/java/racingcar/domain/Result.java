package racingcar.domain;

import java.util.List;

public class Result {
    private RacingCars racingCars;
    private String result;

    public Result(RacingCars racingCars) {
       this.racingCars = racingCars;
       this.result = getwinner();
    }

    private String getwinner() {
        List<RacingCar> racingCarsList = racingCars.getRacingCars();
        String result = "";
        int maxWinnerCount = 0;
        for (int index = 0; index < racingCarsList.size(); index++) {
            RacingCar racingCar = racingCarsList.get(index);
            result = compareWinner(racingCar, maxWinnerCount, result);
            maxWinnerCount = Math.max(maxWinnerCount, racingCar.getGoCount());
        }
        return result.substring(0, result.length() - 1);
    }

    private String compareWinner(RacingCar racingCar, int maxWinnerCount, String result) {
        int racingCarWinCount = racingCar.getGoCount();
        if (maxWinnerCount < racingCarWinCount) {
          return racingCar.getName() + ",";
        } else if (maxWinnerCount == racingCarWinCount) {;
          return result + racingCar.getName() + ",";
        }
        return result;
    }

    public String getResult() {
        return this.result;
    }
}
