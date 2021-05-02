package racing;

import java.util.List;

public class Output {
    public static final String DELIMITER_CAR_NAME = ",";
    private final String output;

    public Output(String output) {
        this.output = output;
    }

    public Output(List<String> names) {
        this(String.join(DELIMITER_CAR_NAME, names));
    }

    @Override
    public boolean equals(Object other) {
        return Comparison.Equals(this, other, obj -> output.equals(obj.output));
    }

    @Override
    public String toString() {
        return output;
    }

    public Output concat(Output step) {
        return this.concat(step.output);
    }

    public Output concat(String other) {
        return new Output(this.output + other);
    }

    public Output concatln(Output step) {
        return new Output(this.output + OutputProvider.NEW_LINE + step.output);
    }
}
