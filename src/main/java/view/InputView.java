package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final String EMPTY_STRING = "";

    private final BufferedReader br;

    public InputView() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String inputRacingCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        return input();
    }

    public String inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return input();
    }

    private String input() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return EMPTY_STRING;
    }

    public void exit() {
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
