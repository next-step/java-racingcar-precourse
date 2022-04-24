package racingcar.model;

public class Location {
    private int figure;
    private String progress;

    public Location() {
        this.figure = 0;
        this.progress = "";
    }

    public void setFigure() {
        this.figure++;
    }

    public String getProgress() {
        progress = "";
        for (int i = 0; i < figure; i++) {
            progress += "-";
        }
        return progress;
    }
}