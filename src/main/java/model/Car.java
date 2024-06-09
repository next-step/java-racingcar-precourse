package model;

// model과 service를 분리해서 도메인 관련 작업만 처리
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

    private void setProgress(int progress) {
        this.progress = progress;
    }

    // 한 칸 앞으로 가는 메서드
    @Override
    public void goForward() {
        setProgress(getProgress() + 1);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getProgress() {
        return progress;
    }
}
