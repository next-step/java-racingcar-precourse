package racingcar.view;

import racingcar.utils.CommonUtils;

public class InputView {
    public static final String INPUT_RACING_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";

    public static String printInputRacingCarNames() {
        System.out.println(INPUT_RACING_CAR_NAMES);
        return CommonUtils.inputText();
    }

    public static String printInputTryCount() {
        System.out.println(INPUT_TRY_COUNT);
        return CommonUtils.inputText();
    }
}
