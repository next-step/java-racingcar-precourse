import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import Service.TryCountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TryCountServiceTest {

    TryCountService count = new TryCountService();

    @Test
    @DisplayName("숫자인지 검증(참)")
    void TrueIsNumber() {
//        given
//        입력으로 오류를 발생시키지 않기 위해 nextLine으로 입력을 받음
//        따라서 입력으로 들어온 문자열 숫자를 검증
        String test = "100";

//        when

//        then
        assertEquals(count.isNumber(test), Integer.parseInt(test));
    }

    @Test
    @DisplayName("숫자인지 검증(오류)")
    void FalseIsNumber() {
//        given
//        입력으로 오류를 발생시키지 않기 위해 nextLine으로 입력을 받음
//        따라서 입력으로 들어온 문자열 숫자를 검증
        String test = "test";

//        when

//        then
        assertThrows(IllegalArgumentException.class, () -> {
            count.isNumber(test);
        });
    }

    @Test
    @DisplayName("숫자인지 검증(소수)")
    void FloatIsNumber() {
//        given
//        입력으로 오류를 발생시키지 않기 위해 nextLine으로 입력을 받음
//        따라서 입력으로 들어온 문자열 숫자를 검증
        String test = "3.141592";

//        when

//        then
        assertThrows(IllegalArgumentException.class, () -> {
            count.isNumber(test);
        });
    }

    @Test
    @DisplayName("숫자인지 검증(오버플로우)")
    void OverflowIsNumber() {
//        given
//        입력으로 오류를 발생시키지 않기 위해 nextLine으로 입력을 받음
//        따라서 입력으로 들어온 문자열 숫자를 검증
        String test = "2147483648";

//        when

//        then
        assertThrows(IllegalStateException.class, () -> {
            count.isNumber(test);
        });
    }

    @Test
    @DisplayName("숫자인지 검증(음수)")
    void NegativeIsNumber() {
//        given
//        입력으로 오류를 발생시키지 않기 위해 nextLine으로 입력을 받음
//        따라서 입력으로 들어온 문자열 숫자를 검증
        String test = "-100";

//        when

//        then
        assertThrows(IllegalArgumentException.class, () -> {
            count.isNumber(test);
        });
    }
}