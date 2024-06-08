package model;

// model과 service를 분리해서 model은 getter, setter, 변수만 갖도록 함.
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
