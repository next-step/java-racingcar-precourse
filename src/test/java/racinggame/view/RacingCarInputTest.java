package racinggame.view;

import org.junit.jupiter.api.DisplayName;
import racinggame.view.RacingCarInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;

public class RacingCarInputTest {
    private String carNames;

    void setup(){
        String wrongCarNames = "test1 test2 test3";
        String exactCarNames = "test1,test2,test3";
    }

    @DisplayName("차이름입력테스트실패")
    @Test
    void splitCarFail(){
        ArrayList<String> answer;
        answer = new ArrayList<String>;
        answer.add("test1");
        answer.add("test2");
        answer.add("test3");
        assertThat(splitCarNames(wrongCarNames) != answer);
    }

    @DisplayName("차이름입력테스트성공")
    @Test
    void splitCarSuccess(){
        ArrayList<String> answer;
        answer = new ArrayList<String>;
        answer.add("test1");
        answer.add("test2");
        answer.add("test3");
        assertThat(splitCarNames(exactCarNames) == answer);
    }
}
