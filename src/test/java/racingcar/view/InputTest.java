package racingcar.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class InputTest extends NsTest {

    private Input input;

    @BeforeEach
    void setUp() {
        input = Input.getInstance();
    }

    @Test
    @DisplayName("input 싱글톤 생성 테스트")
    void inputTest() {
        Input inputSecond = Input.getInstance();
        assertThat(input).isEqualTo(inputSecond);
    }

    @Test
    @DisplayName("input getCarName 테스트")
    void getCarNameTest() {
        assertSimpleTest(
                () -> {
                    run("pobi,java","5");
                    assertThat(output()).contains("pobi").contains("java");
                }
        );
    }

    @Test
    @DisplayName("input getRound 테스트")
    void getRoundTest() {
        assertSimpleTest(
                () -> {
                    run("pobi,java","5");
                    assertThat(output()).contains("5");
                }
        );
    }


    @Override
    public void runMain() {
        System.out.println(input.getCarNames());
        System.out.println(input.getRound());
    }

}