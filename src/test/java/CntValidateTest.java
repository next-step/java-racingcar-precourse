import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CntValidateTest {
    private Rule rule = new Rule();

    @Test
    public void 올바른_값() {
        rule.tryCntInputValid("123");
    }

    @Test
    public void 문자인_경우() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> rule.tryCntInputValid("asdf")
        );
        assert exception.getMessage().equals("[ERROR] 횟수는 숫자만 가능합니다.");
    }

    @Test
    public void 숫자_문자_섞인_경우() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> rule.tryCntInputValid("123sf")
        );
        assert exception.getMessage().equals("[ERROR] 횟수는 숫자만 가능합니다.");
    }
}
