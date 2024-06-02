import org.junit.jupiter.api.Test;

import model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CarTest {

    @Test
    public void validateCarNameLengthThrowsExceptionWhenNameIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car(null);
        });
        assertThat(exception.getMessage()).isEqualTo("[ERROR]name is empty");
    }

    @Test
    public void validateCarNamesThrowsExceptionWhenNameIsTooShort() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car("");
        });
        assertThat(exception.getMessage()).isEqualTo("[ERROR]name length must be between 1 and 5 ");
    }

    @Test
    public void validateCarNamesThrowsExceptionWhenNameIsTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car("Toolongname");
        });
        assertThat(exception.getMessage()).isEqualTo("[ERROR]name length must be between 1 and 5 ");
    }
}
