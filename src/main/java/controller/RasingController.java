package controller;

import domain.Cars;
import service.Racing;
import util.InputParameters;
import util.Message;

public class RasingController {

    public static void main(String[] args) {
        InputParameters inputParameters = new InputParameters();
        Racing racing = new Racing(inputParameters.inputString(Message.INPUT_MSG_MAKE_CAR_NAME));
        racing.getRunningCycle(inputParameters.inputString(Message.INPUT_MSG_ASK_RUNNING_CYCLE));
    }
}
