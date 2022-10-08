package racingcar.model.action.selector.result;

public class ForwardOrStayActionSelectorResult implements ActionSelectorResult {
    private final int forwardOrStayState;

    public ForwardOrStayActionSelectorResult(boolean canForward) {
        if (canForward) {
            forwardOrStayState = ForwardOrStayStatus.CAN_FORWARD;
        } else {
            forwardOrStayState = ForwardOrStayStatus.SHOULD_STAY;
        }
    }

    @Override
    public int nextAction() {
        return forwardOrStayState;
    }
}
