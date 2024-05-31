package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.exception.ProException;

import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {
    private CarName carName;

    @BeforeEach
    void setUp() {
        // CarName 객체를 생성하고 유효한 이름으로 초기화합니다.
        carName = new CarName("테스트차");
    }

    @Test
    void getValue_생성된_이름을_반환합니다() {
        // 생성된 CarName 객체의 값을 가져와서 확인합니다.
        assertEquals("테스트차", carName.getValue());
    }

    @Test
    void 생성자_이름이_null이면_예외를_발생시킵니다() {
        // 이름을 null로 설정하여 예외가 발생하는지 확인합니다.
        assertThrows(ProException.class, () -> new CarName(null));
    }

    @Test
    void 생성자_이름이_빈문자열이면_예외를_발생시킵니다() {
        // 빈 문자열로 이름을 설정하여 예외가 발생하는지 확인합니다.
        assertThrows(ProException.class, () -> new CarName(""));
    }

    @Test
    void 생성자_이름이_5자_이상이면_예외를_발생시킵니다() {
        // 5자 이상의 이름으로 설정하여 예외가 발생하는지 확인합니다.
        assertThrows(ProException.class, () -> new CarName("긴이름입니다"));
    }

    @Test
    void 생성자_유효한_이름이면_예외를_발생시키지_않습니다() {
        // 유효한 이름으로 설정하여 예외가 발생하지 않는지 확인합니다.
        assertDoesNotThrow(() -> new CarName("유효한이름"));
    }
}