package racingcar.model;

public class ResultView {
    private StringBuilder result = new StringBuilder();

    public void merge(StringBuilder turn) {
        result.append(turn)
                .append("\n");
    }

    public String result() {
        return result.toString();
    }
}
