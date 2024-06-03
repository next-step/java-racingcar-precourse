import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import model.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    private final Validator validator = new Validator();
    @Test
    @DisplayName("올바른 입력이 들어왔을 떄")
    public void testNameValidation(){
        // given
        List<String> goodNames = Arrays.asList("a","b","c");
        // when
        boolean valid = validator.checkNames(goodNames);
        //then
        Assertions.assertEquals(true, valid);
    }

    @Test
    @DisplayName("긴 이름이 들어왔을 때")
    public void testNameValidation2(){
        // given
        List<String> longNames = Arrays.asList("a","bbbbbb","c");
        // when
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> validator.checkNames(longNames));
        //then
        assertEquals("리스트에 길이가 5를 초과하는 문자열이 포함되어 있습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("중복된 이름이 들어왔을 때")
    public void testNameValidation3(){
        // given
        List<String> dupNames = Arrays.asList("a","b", "c", "a");
        // when
        Exception exception2 = assertThrows(IllegalArgumentException.class,
            () -> validator.checkNames(dupNames));
        //then
        assertEquals("중복된 이름이 존재합니다.", exception2.getMessage());
    }

    @Test
    @DisplayName("빈 이름이 들어왔을 때")
    public void testNameValidation4(){
        // given
        List<String> longNames = Arrays.asList("","bbbbbb","c");
        // when
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> validator.checkNames(longNames));
        //then
        assertEquals("리스트에 빈 문자열이 포함되어 있습니다.", exception.getMessage());
    }
}
