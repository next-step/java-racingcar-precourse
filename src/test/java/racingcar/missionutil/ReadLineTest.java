package racingcar.missionutil;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

public class ReadLineTest {

    @DisplayName("사용자 입력 테스트")
    @Test
    void readLineTest() {
        //given:
        String inputString = "min,jae";
        InputStream in = new ByteArrayInputStream(inputString.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        //when:
        String read = Console.readLine();
        //then:
        assertThat(read)
                .isEqualTo("min,jae");
    }
}
