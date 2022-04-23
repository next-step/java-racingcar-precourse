package racingcar.domain;

import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
public class RacingCarNames {

    private final List<RacingCarName> names;

    public List<RacingCarName> getNames() {
        return Collections.unmodifiableList(names);
    }
}
