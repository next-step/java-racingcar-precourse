package racinggame.view;

import nextstep.utils.Console;

public class Command {

    public String askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String askAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    public void printHeaderMessage() {
        System.out.println("실행 결과");
    }

    public void printError() {
        System.out.println("[ERROR]");
    }
}
