package racing;

import java.util.List;

public class Output {
    private String output;

    public Output(String output) {
        this.output = output;
    }

    public Output(List<String> names) {
        this(String.join(",", names));
    }

    @Override
    public boolean equals(Object other) {
        return Comparison.Equals(this, other, obj -> output.equals(obj.output));
    }

    @Override
    public String toString() {
        return "Output{'" + output + '\'' + '}';
    }

    public Output concat(Output step) {
        return new Output(this.output + step.output);
    }

    public Output concatln(Output step) {
        return new Output(this.output + "\n" + step.output);
    }
}
