package racing.model;

public class Record {

    private static String BLOCK = "-";

    private String value;

    public Record() {
        this.value = "";
    }

    public void update() {
        this.value += BLOCK;
    }

    public String getValue() {
        return this.value;
    }

    public int getSize() {
        return this.value.length();
    }

}
