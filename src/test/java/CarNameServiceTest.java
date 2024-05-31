import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import DTO.Car;
import Service.CarNameService;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarNameServiceTest {

    CarNameService names = new CarNameService();

    @Test
    @DisplayName("자동차명 검증(참)")
    void TrueCheckNames() {
//        given
        String[] test = {"123", "456", "789"};
//        when

//        then
        List<Car> target = names.checkNames(test);
        String[] name = new String[3];

        for (int i = 0; i < 3; i++) {
            name[i] = target.get(i).getName();
        }

        assertArrayEquals(name, test);
    }


    @Test
    @DisplayName("자동차명 검증(오류)")
    void FalseCheckNames() {
//        given
        String[] test = {"", "123456", "123456789"};
//        when

//        then
        assertThrows(IllegalArgumentException.class, () -> {
            names.checkNames(test);
        });
    }

    @Test
    @DisplayName("자동차명 검증(빈칸)")
    void BlankCheckNames() {
//        given
        String[] test = {" 123", "4 5 6", "789"};
//        when

//        then
        assertThrows(IllegalArgumentException.class, () -> {
            names.checkNames(test);
        });
    }

    @Test
    @DisplayName("자동차명 검증(중복)")
    void DuplicateCheckNames() {
//        given
        String[] test = {"123", "123"};
//        when

//        then
        assertThrows(IllegalArgumentException.class, () -> {
            names.checkNames(test);
        });
    }
}