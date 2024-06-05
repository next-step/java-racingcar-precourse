package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class InputView {

    private static final String REQUEST_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분).";
    private static final String REQUEST_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";
    private final BufferedReader br;

    public InputView() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public InputView(BufferedReader br) {
        this.br = br;
    }

    public String[] inputCarNames() throws IOException {
        System.out.println(REQUEST_CAR_NAMES_MESSAGE);
        String[] carNames = br.readLine().split(",");
        validateCarNames(carNames);
        return carNames;
    }

    private void validateCarNames(String[] carNames) {
        Arrays.stream(carNames).filter(carName -> carName.length() > 5).findAny()
                .ifPresent(carName -> {
                    throw new IllegalArgumentException("[Error] 자동차 이름은 5자 이하만 가능합니다.");
                });
    }

    public int inputTryCount() throws IOException {
        System.out.println(REQUEST_TRY_COUNT_MESSAGE);
        String tryCount = br.readLine();
        validateTryCount(tryCount);
        return Integer.parseInt(tryCount);
    }

    private void validateTryCount(String tryCount) {
        tryCount.chars().filter(ch -> !Character.isDigit(ch)).findAny()
                .ifPresent(ch -> {
                    throw new IllegalArgumentException("[Error] 시도 횟수는 숫자만 가능합니다.");
                });
    }
}
