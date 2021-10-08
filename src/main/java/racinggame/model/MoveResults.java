package racinggame.model;

import java.util.List;

public class MoveResults {
    private final List<MoveResult> results;

    public MoveResults(List<MoveResult> results) {
        this.results = results;
    }

    public String getOutput() {
        StringBuilder sb = new StringBuilder();

        for (MoveResult result : results) {
            String output = result.output();
            sb.append(output);
        }

        return sb.toString();
    }
}
