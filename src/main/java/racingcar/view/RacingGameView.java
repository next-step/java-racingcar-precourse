package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class RacingGameView {

    public static void printStartRacing() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printRacingCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printGameResultTitle() {
        System.out.println("실행 결과");
    }

    public static void printGameResult(Cars cars) {
        for(Car car: cars.getCars()) {
            System.out.printf("\n%s : %s", car.getCarName(), tranferPositionToHyphen(car.getPosition()));
        }
        System.out.println();
    }

    public static String tranferPositionToHyphen(int position) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public static void printWinners(Winners winners) {
        System.out.printf("최종 우승자 : %s%n", winners.getWinRacers());
    }
}
