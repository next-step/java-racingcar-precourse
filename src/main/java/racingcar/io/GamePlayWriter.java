package racingcar.io;

import racingcar.car.domain.models.Cars;
import racingcar.car.domain.models.Winners;

public class GamePlayWriter {

    private GamePlayWriter() {
    }

    public static void printRequirePlayerName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printRequirePlayerTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printPlayResult() {
        System.out.println("실행 결과");
    }

    public static void printWinners(Winners winners) {
        System.out.println("최종 우승자: " + winners.toString());
    }

    public static void printEachGameResult(Cars cars) {
        System.out.println(cars.toString());
    }
}
