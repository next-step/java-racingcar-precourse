package racinggame.view;

import nextstep.utils.Console;
import racinggame.domain.Car;

public class Command {

    public String askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String askAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printError() {
        System.out.println("[ERROR]");
    }

    public void printCar(Car car) {
        System.out.println(car.getCarName()+" : "+car.getDistanceStr());
    }

    public void println() {
        System.out.println();
    }

    public void printWinner(String winnerStr) {
        System.out.println("최종 우승자는 " + winnerStr + " 입니다.");
    }
}
