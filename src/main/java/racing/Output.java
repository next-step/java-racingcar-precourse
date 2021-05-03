package racing;

public class Output {
    private final String output;

    public Output(String output) {
        this.output = output;
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
