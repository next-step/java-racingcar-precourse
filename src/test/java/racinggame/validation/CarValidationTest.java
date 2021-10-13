package racinggame.validation;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CarValidationTest {

    @Test
    void 차_이름_범위_확인() {
        boolean actual =  CarValidation.isAvailableRange("insoo");

        assertEquals(true, actual);
    }

    @Test
    void 차_이름_중복_확인() {
        Set<String> carSet = new HashSet<>();
        carSet.add("insoo");

        boolean actual =  CarValidation.isDuplicated(carSet, "insu");
        assertEquals(true, actual);
    }
}