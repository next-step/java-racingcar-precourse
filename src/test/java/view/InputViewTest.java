package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputViewTest {

    @BeforeEach
    void setUp() {
        // Reset System.in before each test
        System.setIn(System.in);
    }

    @Test
    void 자동차_이름_입력_테스트() {
        String input = "pobi,woni,jun\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);

        String[] carNames = inputView.getCarNames();
        assertArrayEquals(new String[]{"pobi", "woni", "jun"}, carNames);
    }

    @Test
    void 시도_횟수_입력_테스트() {
        String input = "5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);  // 새로운 Scanner 인스턴스를 생성합니다.
        InputView inputView = new InputView(scanner);  // InputView에 새로운 Scanner를 전달합니다.

        int attemptCount = inputView.getAttemptCount();
        assertEquals(5, attemptCount);
    }
}
