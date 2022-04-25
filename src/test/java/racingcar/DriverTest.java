package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import racingcar.domain.Driver;

public class DriverTest {
    Driver driver;

    @BeforeEach
    void setUp(){
        driver = new Driver("pobi");
    }

    @Test
    @Order(1)
    void 간다(){
        Assertions.assertThat(driver.move(4)).isEqualTo("-");
    }

    @Test
    @Order(2)
    void 안간다(){
        Assertions.assertThat(driver.move(3)).isEqualTo("");
    }
}
