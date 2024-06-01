package VIew;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputView {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 개행 없이 매개변수 message 출력
    public static void output(String message) throws IOException {
        bw.write(message);
        bw.flush();
    }

    // 개행 있이 매개변수 message 출력
    public static void outputLine(String message) throws IOException {
        bw.write(message + "\n");
        bw.flush();
    }

    // 자동차 이름 입력 문구 출력
    public static void outputInputCarNameMessage() throws IOException {
        bw.write("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분\n");
        bw.flush();
    }

    // 실행 결과 문구 출력
    public static void outputGameResultMessage() throws IOException {
        bw.write("실행 결과\n");
        bw.flush();
    }

    // 최종 우승자 문구 및 우승자 출력
    public static void outputGameWinner(String winners) throws IOException {
        bw.write("최종 우승자 : " + winners + "\n");
        bw.flush();
    }
}
