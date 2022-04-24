package racingcar.domain;

public class MoveResult {

    private final StringBuilder results;

    MoveResult() {
        this.results = new StringBuilder();
    }

    void add(String name, int moveCount) {
        results.append(name)
                .append(" : ")
                .append(convertToHyphen(moveCount))
                .append("\n");
    }

    private String convertToHyphen(int moveCount) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < moveCount; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return results.toString();
    }
}