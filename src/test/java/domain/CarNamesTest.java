package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNamesTest {
    @Test
    public void 이름들은_구분자로_나눠서_이름을_만든다() {
        String name = "a,b,c,d,e";

        CarNames carNames = new CarNames(name);

        assertThat(carNames.getNames())
                .contains(
                        new CarName("a"),
                        new CarName("b"),
                        new CarName("c"),
                        new CarName("d"),
                        new CarName("e")
                );
    }
}
