package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static String inputCarsName() {
        ResultView.getInputCarsNameMessage();
        return readLine();
    }

    public static int inputTryNumber() {
        ResultView.getInputTryNumberMessage();

        int tryNumber = Integer.parseInt(readLine());

        if(tryNumber > 0){
            return tryNumber;
        }

        throw new IllegalArgumentException(ResultView.ERROR_NOT_INTEGER);
    }
}
