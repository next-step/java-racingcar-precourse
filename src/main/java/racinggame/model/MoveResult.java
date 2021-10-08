package racinggame.model;

public class MoveResult {
    private static final String COLON = " : ";
    private static final String NEXT_LINE = "\n";

    private final String name;
    private final String road;

    public MoveResult(String name, String road) {
        this.name = name;
        this.road = road;
    }

    public String output() {
        return name + COLON + road + NEXT_LINE;
    }
}
