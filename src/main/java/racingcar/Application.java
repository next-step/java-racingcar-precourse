package racingcar;

import racingcar.controller.CircuitController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CircuitController circuitController = new CircuitController();
        circuitController.prepareCircuit();
        circuitController.runCircuit();
        circuitController.pickWinner();
    }
}
