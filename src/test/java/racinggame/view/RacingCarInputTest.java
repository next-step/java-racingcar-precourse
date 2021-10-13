package racinggame.view;

import org.junit.jupiter.api.DisplayName;
import racinggame.view.RacingCarInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import racinggame.view.RacingCarInput;

public class RacingCarInputTest {
    private String wrongCarNames;
    private String exactCarNames;
    private RacingCarInput racingCarInput;

    @BeforeEach
    void setup(){
        wrongCarNames = "test1 test2 test3";
        exactCarNames = "test1,test2,test3";
        racingCarInput = new RacingCarInput();
    }

    @DisplayName("차이름입력테스트실패")
    @Test
    void splitCarFail(){
        String[] answer = {"test1, test2, test3"};
        assertThat(racingCarInput.splitCarNames(wrongCarNames) != answer);
    }

    @DisplayName("차이름입력테스트성공")
    @Test
    void splitCarSuccess(){
        String[] answer = {"test1, test2, test3"};
        assertThat(racingCarInput.splitCarNames(exactCarNames) == answer);
    }

    @DisplayName("반복입력횟수설정테스트")
    @Test
    void inputRepeactCount(){
        int repeatCount = 5;
        racingCarInput.setRepeactCount(repeatCount);
        assertThat(racingCarInput.getRepeactCount() == repeatCount);
    }

}
