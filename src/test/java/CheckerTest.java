import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Checker;

public class CheckerTest {
    Checker checker=new Checker();
    @Test
    @DisplayName("이름 범위 CheckTest")
    void carNameRangeCheckTest(){
        List<String > carNames= List.of("Faker","Keria","Zeus","Gumayusi","Owner");
        assertThatThrownBy(()->checker.carNameRangeCheck(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]이름의 길이를 잘못 입력, 다시 입력해 주세요");
    }
    @Test
    @DisplayName("이름 중복 CheckTest")
    void carNameDuplicationCheckTest(){
        List<String > carNames= List.of("Faker","Faker","Zeus");
        assertThatThrownBy(()->checker.carNameDuplicationCheck(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]중복된 이름를 입력, 다시 입력해 주세요");
    }
    @Test
    @DisplayName("문장 주어졌을시 올바르게 Check하는지 Test")
    void checkCarNameTest(){
        String carNames="Faker,Zeus,Keria";
        List<String> names=checker.checkCarName(carNames);
        assertThat(names).containsExactly("Faker","Zeus","Keria");
    }
    @Test
    @DisplayName("올바른 숫자인지 Test")
    void isNumericTest(){
        assertThatThrownBy(()->checker.isNumeric("T1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]잘못된 숫자를 입력, 다시 입력해 주세요");

        assertThatThrownBy(()->checker.isNumeric("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]잘못된 숫자를 입력, 다시 입력해 주세요");
        assertThat(checker.isNumeric("1234")).isTrue();
    }
}
