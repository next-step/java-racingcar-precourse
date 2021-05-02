package view.print;

import domain.Position;

import java.io.StringWriter;

public class PositionPrinter {
    private static final String POSITION_PRINTING_STRING = "-";

    private Position position;

    public PositionPrinter(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        StringWriter stringWriter = new StringWriter();

        stringWriter.write(String.format("%s : ", position.getCarName()));

        for(int i = 0; i<position.getPosition(); i++) {
            stringWriter.append(POSITION_PRINTING_STRING);
        }

        return stringWriter.toString();
    }
}
