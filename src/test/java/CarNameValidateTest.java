import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameValidateTest {
    private Rule rule = new Rule();

    @Test
    public void 자동차_이름_null() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> rule.carNameIsNull(null)
        );
        assert exception.getMessage().equals("[ERROR] 자동자 이름이 비어있습니다.");
    }

    @Test
    public void 자동차_이름_Empty_String() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> rule.carNameIsNull("")
        );
        assert exception.getMessage().equals("[ERROR] 자동자 이름이 비어있습니다.");
    }

    @Test
    public void 자동차_이름_6자_넘어감() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> rule.carNameIsOverSize("asdfasdf")
        );
        assert exception.getMessage().equals("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
    }

    @Test
    public void 자동자_이름_올바른_경우() {
        rule.carNameIsOverSize("car1,car2,car3");
    }
}
