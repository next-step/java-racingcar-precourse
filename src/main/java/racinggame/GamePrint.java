package racinggame;

import racinggame.car.CarList;

public class GamePrint {

    public void printCarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryCountInput() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResult() {
        System.out.println("\n실행 결과");
    }

    public void printProcessing(CarList list) {
        System.out.println(list.getProcessResult());
    }

    public void printWinner(CarList list) {
        System.out.println("최종 우승자는 " + list.getWinners() + " 입니다.");
    }

    public void PrintError(String message) {
        System.out.println("[ERROR]" + message);
    }
}
