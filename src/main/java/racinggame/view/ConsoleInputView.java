package racinggame.view;

import nextstep.utils.Console;

public class ConsoleInputView {

    public String enterNames() {
        System.out.println("경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)");
        return Console.readLine();
    }
}
