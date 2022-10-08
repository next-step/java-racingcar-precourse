package racingcar.view;

import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

public class RacingView {

    public void printInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printExceptionMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    public void printPrepareRacing() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRacingCarsOffset(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getCars()) {
            printRacingCarNameAndOffset(racingCar);
        }
        System.out.println();
    }

    private void printRacingCarNameAndOffset(RacingCar racingCar) {
        System.out.print(racingCar.getName() + " : ");
        printRacingCarOffset(racingCar);
    }

    private void printRacingCarOffset(RacingCar racingCar) {
        for (int i = 0; i < racingCar.getOffset(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printRacingWinners(RacingCars racingCars) {
        System.out.println("최종 우승자 : " + racingCars.getWinnersName());
    }
}
