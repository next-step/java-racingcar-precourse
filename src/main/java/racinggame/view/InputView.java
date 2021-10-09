package racinggame.view;

import nextstep.utils.Console;

public class InputView {

    public static InputView of() {
        return new InputView();
    }

    public String insertCarNames(){
        System.out.println("경주할자동차이름을입력하세요.(이름은쉼표(,)기준으로구분)");
        return Console.readLine();
    }

    public int insertTryCount(){
        System.out.println("시도할회수는몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

}
