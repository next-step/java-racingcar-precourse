package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {

    public void printCarNameScript() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public String getInput() {
        return Console.readLine();
    }

    public void printTryCountScript() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public void print(String moveResult) {
        System.out.println(moveResult);
    }

    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }

    public void printWinner(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
