package racingcar.view;

import racingcar.NoticeMessages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static String inputCarNames() throws IOException {
        System.out.println(NoticeMessages.INPUT_CAR_NAMES);
        return bufferedReader.readLine();
    }

    public static String inputTryCount() throws IOException {
        System.out.println(NoticeMessages.INPUT_TRY_CNT);
        return bufferedReader.readLine();
    }
}
