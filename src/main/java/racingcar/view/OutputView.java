package racingcar.view;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingResult;

import java.util.List;

public class OutputView {

    public static void resultCar(List<RacingCar> racingCars) {
        racingCars.stream().forEach(car -> System.out.println(getResult(car)));
        System.out.println();
    }

    private static String getResult(RacingCar car) {

        String result = car.getName() + " : ";

        for(int i = 0; i < car.moveCnt(); i++) {
            result += "-";
        }

        return result;
    }

    public static void getWinRacing(RacingResult result) {
        String winRacingCar = "";
        for(RacingCar car : result.getWinRacingCar()) {
            winRacingCar += car.getName() + ", ";
        }
        winRacingCar = winRacingCar.replaceAll(", $", "");

        System.out.println("=== 주행 결과 ===");
        System.out.println("최종 우승자 : " + winRacingCar);
    }
}
