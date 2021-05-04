import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTest {

    @ParameterizedTest()
    @ValueSource(strings = {
            "aaa,bbb,ccc,ddd,eee,fff,ggg,hhh",
            "aaa,bbb,ccc,ddd,eee,fff,ggg",
            "aaa,bbb , ccc,    ddd , eee ,fff,ggg,hhh",
            "aaa",
            "aaa,bbb,ccc,ddd,eee,fff,ggg,hhh,iii,jjj",
    })
    void test_차량의_이름이_1개_이상_10개_이하라면_에러없이_실행() throws InvalidCarNameException {
        String inputCarNames = "aaa,bbb,ccc,ddd,eee,fff,ggg,hhh";
        Validator.validCheckCarNames(inputCarNames);
    }

    @Test
    void test_차량의_이름과_구분자_사이에_스페이스바가_있어도_1개_이상_10개_이하라면_true_리턴() throws InvalidCarNameException {
        String inputCarNames;
        inputCarNames = "aaa,bbb , ccc,    ddd , eee ,fff,ggg,hhh";
        Validator.validCheckCarNames(inputCarNames);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaa", ""})
    void test_차량의_이름이_1개_이하라면_Exception_발생(String inputCarNames) throws InvalidCarNameException {
        assertThrows(InvalidCarNameException.class, () -> {
            Validator.validCheckCarNames(inputCarNames);
        });

    }
}
