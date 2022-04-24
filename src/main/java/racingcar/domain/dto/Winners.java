package racingcar.domain.dto;

import racingcar.domain.Name;
import racingcar.domain.Names;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Winners {

    private static final String DELIMITER = ",";
    private final Names winners;

    private Winners(Names winners) {
        this.winners = winners;
    }

    public static Winners from(Names names) {
        return new Winners(names);
    }

    public String getWinnersString() {
        List<Name> names = winners.getNames();
        List<String> namesStr = new ArrayList<>();
        for (Name name : names) {
            namesStr.add(name.getValue());
        }
        return String.join(DELIMITER, namesStr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Winners winners1 = (Winners) o;
        return Objects.equals(winners, winners1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
