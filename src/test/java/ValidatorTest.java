import Controller.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {
    private final Validator validator = new Validator();

    @Test
    @DisplayName("입력에 공백 존재")
    void InputValidatorTest1(){
        assertThatException().
            isThrownBy(()->validator.InputValidator("a,b,c, ,d"))
            .withMessage("자동차 이름에 공백은 포함될 수 없습니다.");
    }
    @Test
    @DisplayName("이름 길이 초과")
    void InputValidatorTest2(){
        assertThatException().
            isThrownBy(()->validator.InputValidator("aaaa,bbbbbb,c,d"))
            .withMessage("자동차 이름은 5자를 넘을수 없습니다.");
    }
    @Test
    @DisplayName("중복 이름 존재")
    void InputValidatorTest3(){
        assertThatException().
            isThrownBy(()->validator.DuplicationValidator("AA,BB,AA,CC"))
            .withMessage("중복되는 이름이 존재합니다.");
    }
}
