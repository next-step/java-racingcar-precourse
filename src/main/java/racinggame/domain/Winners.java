package racinggame.domain;

import java.util.List;
import java.util.Objects;

public class Winners {
    private List<Name> winners;

    public Winners(List<Name> winners) {
        this.winners = winners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Winners)) {
            return false;
        }
        Winners winners1 = (Winners)o;
        return Objects.equals(winners, winners1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }
}
