package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void create_car() {
        Car superCar = new Car("super");
        assertNotNull(superCar);
        assertEquals(0, superCar.getMileage());
    }

    @Test
    void null_name() {
        assertThrows(IllegalArgumentException.class, () -> new Car(null));
    }

    @Test
    void empty_name() {
        assertThrows(IllegalArgumentException.class, () -> new Car(""));
    }

    @Test
    void name_over_length() {
        assertThrows(IllegalArgumentException.class, () -> new Car("012345"));
    }

    @Test
    void super_car_drive_one_mileage() {
        Car superCar = new Car("super");
        superCar.drive(4);
        assertEquals(1, superCar.getMileage());
    }

    @Test
    void super_car_drive_zero_mileage() {
        Car superCar = new Car("super");
        superCar.drive(3);
        assertEquals(0, superCar.getMileage());
    }


}