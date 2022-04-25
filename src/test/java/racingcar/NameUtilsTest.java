package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NameUtilsTest {
    @Test
    void mapToList(){
        String strNames = " pobi, weno ";
        List<Name> names = NameUtils.mapToList(strNames);

        assertThat(names.get(0)).isEqualTo(new Name("pobi"));
        assertThat(names.get(1)).isEqualTo(new Name("weno"));
    }
}
