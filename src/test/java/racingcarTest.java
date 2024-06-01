import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

public class racingcarTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setup() {
        // 각 테스트 전에 초기화가 필요한 필드나 리스트를 초기화합니다.
        Application.nameArray = null;
        Application.nameList = new ArrayList<>();
        Application.chance = 0;
        Application.arr = new ArrayList<>();
        Application.cardistance = new ArrayList<>();
        Application.top = new ArrayList<>();
        Application.a = 0;

        // 콘솔 출력 캡처
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        // 원래 콘솔 출력으로 복구
        System.setOut(originalOut);
    }


    @Test
    void testMakeNumber() {
        // 난수 생성 테스트
        Application.nameArray = new String[] {"car1", "car2"};
        Application.makeNumber();
        assertEquals(2, Application.arr.size());
        Application.arr.forEach(num -> assertTrue(num >= 0 && num < 10));
    }

    @Test
    void testGoStop() {
        // 전진 로직 테스트
        Application.nameArray = new String[] {"car1", "car2"};
        Application.nameList = new ArrayList<>(List.of(Application.nameArray));
        Application.cardistance.add(0);
        Application.cardistance.add(0);

        // 사전 정의된 난수 리스트를 사용
        Application.arr = new ArrayList<>(List.of(4, 3));
        Application.goStop();

        assertEquals(1, Application.cardistance.get(0));
        assertEquals(0, Application.cardistance.get(1));
    }


}
