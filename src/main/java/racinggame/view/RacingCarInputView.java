package racinggame.view;

import nextstep.utils.Console;
import racinggame.utils.ParseUtils;

import java.util.Arrays;
import java.util.List;


public class RacingCarInputView {

    private RacingCarInputView() {}

    public static List<String> receiveCarName() {
        return Arrays.asList(ParseUtils.parseByClassification(Console.readLine()));
    }

    public static int receiveTryCount() {
        return ParseUtils.parseStringToInt(Console.readLine());
    }

}
