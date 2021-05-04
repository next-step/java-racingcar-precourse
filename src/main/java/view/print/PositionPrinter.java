package view.print;

import java.io.StringWriter;

import domain.history.CarHistory;

public class PositionPrinter {
    private static final String POSITION_PRINTING_STRING = "-";

    private CarHistory carHistory;

    public PositionPrinter(CarHistory carHistory) {
        this.carHistory = carHistory;
    }

    @Override
    public String toString() {
        StringWriter stringWriter = new StringWriter();

        stringWriter.write(String.format("%s : ", carHistory.getCarName()));

        for (int i = 0; i < carHistory.getPosition().toInt(); i++) {
            stringWriter.append(POSITION_PRINTING_STRING);
        }

        return stringWriter.toString();
    }
}
