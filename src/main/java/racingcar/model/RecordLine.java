package racingcar.model;

public class RecordLine {

    private final String MILEAGE_MARK = "-";
    private final String DELIMITER = " ";
    private final String COLON = ":";

    private String recordLine;

    public RecordLine() {
        this.recordLine = "";
    }

    public void addRecordLine() {
        this.recordLine = this.recordLine + MILEAGE_MARK;
    }

    public void writeRecordLine(String carName) {
        System.out.println(String.join(DELIMITER, carName, COLON, recordLine));
    }
}
