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

    // getter
    @Override
    public String getName() {
        return name;
    }

    // getter
    @Override
    public int getProgress() {
        return progress;
    }

    // 한 칸 앞으로 가는 메서드
    private void goForward() {
        setProgress(getProgress() + 1);
    }

    // 난수에 따라 한 칸 전진할지 결정하는 메서드
    @Override
    public void moveOrNot() {
        // 랜덤 변수를 생성한 후
        int randomNumber = (int) (Math.random() * 10);

        // 만약 4 이상이라면
        if (randomNumber > 3) {
            // 앞으로 전진한다.
            goForward();
        }
    }
}
