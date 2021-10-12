package racinggame.view;

import java.util.List;

import racinggame.code.InGameText;
import racinggame.exception.RacinggameException;

public class RacinggameOutputView {
    public static void executeResult() {
        System.out.println(InGameText.EMPTY_LINE.getValue() + InGameText.EXECUTE_RESULT.getValue());
    }

    public static void roundResult(List<String> intermediateResults) {
        for (String intermediateResult : intermediateResults) {
            System.out.println(intermediateResult);
        }
        System.out.print(InGameText.EMPTY_LINE.getValue());
    }

    public static void gameResult(String firstPlace) {
        System.out.println(
                InGameText.FIRST_PLACE_START.getValue() + firstPlace + InGameText.FIRST_PLACE_END.getValue()
        );
    }

    public static void error(RacinggameException racinggameException) {
        System.out.println(racinggameException.getMessage());
    }
}
