package racingcar.view;

import racingcar.utils.Validate;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.utils.Contant.*;

public class View {
    private final Validate validate = new Validate();

    public String[] inputCarNameView(){
        System.out.println(VIEW_INPUT_NAMES);
        String[] names;
        do {
            names = readLine().split(",");
        } while (!validate.isValidInputNames(names));
        return names;
    }

    public int inputTryCountView() {
        System.out.println(VIEW_INPUT_TRY_COUNT);
        String count;
        do {
            count = readLine();
        } while(!validate.isValidCount(count));
        return Integer.parseInt(count);
    }

    public void outputResultView() {
        System.out.println();
        System.out.println(VIEW_EXECUTION_RESULT);
    }
}
