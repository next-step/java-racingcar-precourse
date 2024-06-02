import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CarTest {

    @Test
    @DisplayName("when name is null")
    public void validateCarNameLengthThrowsExceptionWhenNameIsNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car(null);
        });
        assertThat(exception.getMessage()).isEqualTo("[ERROR]name is empty");
    }

    @Test
    @DisplayName("When the car's name is less than 1")
    public void validateCarNamesThrowsExceptionWhenNameIsTooShort() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car("");
        });
        assertThat(exception.getMessage()).isEqualTo("[ERROR]name length must be between 1 and 5 ");
    }

    @Test
    @DisplayName("When the car's name is more than 5")
    public void validateCarNamesThrowsExceptionWhenNameIsTooLong() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Car car = new Car("Toolongname");
        });
        assertThat(exception.getMessage()).isEqualTo("[ERROR]name length must be between 1 and 5 ");
    }
}
