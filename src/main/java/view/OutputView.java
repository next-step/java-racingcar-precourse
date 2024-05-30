package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.PrintStream;
import java.util.List;

public class OutputView implements PropertyChangeListener {

    public OutputView(PrintStream printStream) {
        System.setOut(printStream);
    }

    public void println(String str) {
        System.out.println(str);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("raceStatusUpdate".equals(evt.getPropertyName())) {
            displayRaceStatus((List<String>) evt.getNewValue());
        }
        if ("raceFinished".equals(evt.getPropertyName())) {
            displayWinner((List<String>) evt.getNewValue());
        }
    }

    private void displayRaceStatus(List<String> raceStatus) {
        for (String carStatus : raceStatus) {
            this.println(carStatus);
        }
        System.out.println();
    }

    private void displayWinner(List<String> winnerList) {
        String winners = String.join(", ", winnerList);
        this.println("최종 우승자 : " + winners);
    }
}
