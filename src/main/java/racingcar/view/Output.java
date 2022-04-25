package racingcar.view;


import racingcar.domain.Car;
import racingcar.domain.CarPosition;
import racingcar.domain.Cars;
import racingcar.domain.RacingResult;

public class Output {
    public static void outputWinnerNames(RacingResult racingResult) {
        String winnerNames = racingResult.getWinnerNames();
        System.out.println("최종 우승자: " + winnerNames);
    }

    public static void viewCurrentPosition(Cars cars) {
        for (Car car : cars.getCars()) {
            String printString = car.getName() + " : " + getHyphenRoad(car.getPosition());
            System.out.println(printString);
        }
        System.out.println();
    }

    /**
     * 현재 위치를 -(하이픈)으로 표시
     */
    static String getHyphenRoad(int position) {
        StringBuilder hyphenRoad = new StringBuilder();
        for (int i = 0; i < position; i++) {
            hyphenRoad.append("-");
        }
        return hyphenRoad.toString();
    }
}
