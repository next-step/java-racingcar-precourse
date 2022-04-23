package racingcar.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RacingCarName {
    @Getter
    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
