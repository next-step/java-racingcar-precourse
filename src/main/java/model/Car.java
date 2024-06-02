package model;

public class Car implements CarModelInterface {

    private final String name;
    private int progress;

    public Car() {
        name = "";
        progress = 0;
    }

    public Car(String name, int progress) {
        this.name = name;
        this.progress = progress;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getProgress() {
        return progress;
    }

    @Override
    public void setProgress(int progress) {
        this.progress = progress;
    }
}
