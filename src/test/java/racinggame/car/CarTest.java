package racinggame.car;

import org.junit.jupiter.api.Test;
import racinggame.domain.CarName;
import racinggame.domain.CarNames;
import racinggame.error.ValidationFailureException;
import racinggame.domain.SeedForMove;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    public void 전진시드값이_0에서9사이의_정수가_아닌경우_ValidationFailureException_발생() {
        assertThrows(ValidationFailureException.class, () -> SeedForMove.from(-1));
        assertDoesNotThrow(() -> SeedForMove.from(0));
        assertDoesNotThrow(() -> SeedForMove.from(9));
        assertThrows(ValidationFailureException.class, () -> SeedForMove.from(10));
    }

    @Test
    public void 전진시드값이_3이하면_멈춤_4이상이면_전진() {
        assertFalse(SeedForMove.from(3).shouldMoving());
        assertTrue(SeedForMove.from(4).shouldMoving());
        assertTrue(SeedForMove.from(3).shouldStop());
        assertFalse(SeedForMove.from(4).shouldStop());
    }

    @Test
    public void 자동차의_이름이_1자이상_5자_이하가_아닌경우_ValidationFailureException_발생() {
        assertThrows(ValidationFailureException.class, () -> CarName.from("abcdefa"));
        assertDoesNotThrow(() -> CarName.from("abcde"));
        assertDoesNotThrow(() -> CarName.from("a"));
        assertThrows(ValidationFailureException.class, () -> CarName.from(""));
    }

    @Test
    public void 자동차_이름들_사이에만_쉼표가_존재하지않을경우_ValidationFailureException_발생(){
        assertThrows(ValidationFailureException.class, () -> CarNames.from(",abc,bcd,ecf,"));
        assertThrows(ValidationFailureException.class, () -> CarNames.from("abc,bcd,ecf,"));
        assertThrows(ValidationFailureException.class, () -> CarNames.from(",abc,bcd,ecf"));
        assertDoesNotThrow(() -> CarNames.from("abc,bcd,ecf"));
    }
}
