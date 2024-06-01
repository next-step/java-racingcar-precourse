import java.util.List;

public class OutputProcessor {
    private Output output = new Output();

    public void processWinnerName(List<Car> winners) {
        output.winnerOutput(winners);
    }
}
