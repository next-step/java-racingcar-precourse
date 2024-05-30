package VIew;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //이름을 입력받는 메소드
    public static String inputName() throws IOException {
        return br.readLine();
    }

    //숫자를 입력받는 메소드
    public static String inputNumberOfAttempts() throws IOException {
        return br.readLine();
    }
}
