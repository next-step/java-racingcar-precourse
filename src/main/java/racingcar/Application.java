package racingcar;

import racingcar.controller.OperatorController;

public class Application {
    private static OperatorController operatorController = OperatorController.getInstance();
    public static void main(String[] args) {
        operatorController.initOperator();
    }
}
