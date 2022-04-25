package racingcar.domain.result;

import java.util.List;

public class WinNames {
    private List<String> winNames;

    public WinNames(List<String> winNames) {
        this.winNames = winNames;
    }

    public List<String> getWinNames() {
        return winNames;
    }

    @Override
    public String toString() {
        return String.join(", ", winNames);
    }
}
