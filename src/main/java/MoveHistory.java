import java.util.ArrayList;
import java.util.List;

public class MoveHistory {
    private List<Movement> moves;

    public MoveHistory() {
        this.moves = new ArrayList<>();
    }

    public void add(Movement movement) {
        this.moves.add(movement);
    }

    public int countMoves() {
        return this.moves.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Movement movement : this.moves) {
            sb.append(movement.toString());
        }

        return sb.toString();
    }
}
