package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RaceGameTest extends NsTest {

    public static final String TEST_STRING = "10d";
    public static final String ERROR_MESSAGE = "[ERROR]";
    RaceGame raceGame;
    @BeforeEach
    void setUp(){
        this.raceGame = new RaceGame();
        System.setIn(new ByteArrayInputStream(TEST_STRING.getBytes()));
    }

    @Test
    void 입력값_받기(){
        assertThat( raceGame.inputCarName())
                .isNotEmpty()
                .isEqualTo(TEST_STRING);
    }
    @Test
    void 에러_메세지확인(){
        assertThatThrownBy(()-> {
            raceGame.lengthValidation("sonata");
        }).hasMessageContaining(ERROR_MESSAGE);
    }
    @Test
    void 차_이름_길이_에러종류확인(){
        assertThatThrownBy(()-> {
            raceGame.lengthValidation("sonata");
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 차_구분하기_에러체크(){
        assertThatThrownBy(()-> {
            raceGame.splitValidation("dkdkdk,");
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 입력된차_출력(){
        assertThat(raceGame.inputArray("bb,dd,ee"))
                .isNotEmpty();
    }
    @Test
    void 랜덤값테스트(){
        assertThat(raceGame.inputRandomNumber())
                .isGreaterThan(0)
                .isLessThan(10)
                .isNotEqualTo(0)
                .isNotEqualTo(10);
    }
    @Test
    void 실행횟수_입력값체크(){
        assertThatThrownBy(()->{
            raceGame.inputGameCount();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {

    }
}
